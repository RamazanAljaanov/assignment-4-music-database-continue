package repository;

import DataBase_connection.DataBaseConnection;
import model.Artist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    // Метод должен принимать String name!
    public void create(String name) throws SQLException {
        String sql = "INSERT INTO artists (name) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name); // Сюда заходит строка, всё ок
            ps.executeUpdate();
        }
    }

    public List<Artist> getAll() throws SQLException {
        List<Artist> list = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM artists")) {
            while (rs.next()) {
                list.add(new Artist(rs.getInt("id"), rs.getString("name")));
            }
        }
        return list;
    }
}