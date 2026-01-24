package service;

import model.Artist;
import repository.ArtistRepository;
import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    private final ArtistRepository repo = new ArtistRepository();

    public void addArtist(String name) throws SQLException {
        // Ошибка могла быть тут: мы передаем просто name (это String)
        repo.create(name);
    }

    public List<Artist> getAll() throws SQLException {
        return repo.getAll();
    }
}