package repository;

import DataBase_connection.DataBaseConnection;
import model.Artist;
import repository.interfaces.ArtistRepositoryInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository implements ArtistRepositoryInterface {

    @Override
    public void create(String name) {
        create(new Artist(0, name));
    }

    @Override
    public void create(Artist a) {
        String sql = "INSERT INTO artists (name) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e); // потом можно заменить на DatabaseOperationException
        }
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> list = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM artists")) {
            while (rs.next()) {
                list.add(new Artist(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void update(int id, Artist a) {
        String sql = "UPDATE artists SET name=? WHERE id=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getName());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM artists WHERE id=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

