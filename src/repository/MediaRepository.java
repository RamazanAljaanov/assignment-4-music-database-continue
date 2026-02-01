package repository;

import DataBase_connection.DataBaseConnection;
import model.*;
import repository.interfaces.MediaRepositoryInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MediaRepository implements MediaRepositoryInterface {

    @Override
    public int addMedia(Media m) {
        try (Connection conn = DataBaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            String sqlM = "INSERT INTO media (title, duration_sec) VALUES (?, ?) RETURNING id";
            try (PreparedStatement psM = conn.prepareStatement(sqlM)) {
                psM.setString(1, m.getTitle());
                psM.setInt(2, m.getDuration());

                ResultSet rs = psM.executeQuery();
                if (!rs.next()) {
                    conn.rollback();
                    return -1;
                }

                int mid = rs.getInt(1);

                if (m instanceof Song s) {
                    try (PreparedStatement psS = conn.prepareStatement(
                            "INSERT INTO songs (media_id, artist_id, genre) VALUES (?, ?, ?)")) {
                        psS.setInt(1, mid);
                        psS.setInt(2, s.getArtist().getId());
                        psS.setString(3, s.getGenre());
                        psS.executeUpdate();
                    }
                } else if (m instanceof Podcast) {
                    try (PreparedStatement psP = conn.prepareStatement(
                            "INSERT INTO podcasts (media_id, host_name) VALUES (?, ?)")) {
                        psP.setInt(1, mid);
                        psP.setString(2, "Unknown Host");
                        psP.executeUpdate();
                    }
                }

                conn.commit();
                return mid;

            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Media> getAll() {
        List<Media> list = new ArrayList<>();
        String sql = """
            SELECT m.*, s.genre, a.id as aid, a.name as aname
            FROM media m
            LEFT JOIN songs s ON m.id = s.media_id
            LEFT JOIN artists a ON s.artist_id = a.id
        """;

        try (Connection conn = DataBaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                if (rs.getString("genre") != null) {
                    list.add(new Song(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("duration_sec"),
                            rs.getString("genre"),
                            new Artist(rs.getInt("aid"), rs.getString("aname"))
                    ));
                } else {
                    list.add(new Podcast(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("duration_sec"),
                            "Host"
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void updateTitle(int id, String newTitle) {
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE media SET title = ? WHERE id = ?")) {
            ps.setString(1, newTitle);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM media WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createPlaylist(String name) {
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO playlists (name) VALUES (?)")) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
