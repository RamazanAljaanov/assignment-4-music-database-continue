package service;
import dto.MediaDTO;
import exception.*;
import model.*;
import repository.MediaRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaService {
    private final MediaRepository repo = new MediaRepository();

    public void addMedia(Media m) throws Exception {
        if (m.getTitle().trim().isEmpty()) throw new InvalidInputException("Title empty!");
        repo.addMedia(m);
    }

    public List<MediaDTO> getAllAsDTO() throws SQLException {
        List<MediaDTO> dtos = new ArrayList<>();
        for (Media m : repo.getAll()) {
            MediaDTO d = new MediaDTO(); d.id = m.getId(); d.title = m.getTitle();
            d.info = (m instanceof Song) ? ((Song)m).getArtist().getName() : "Podcast";
            dtos.add(d);
        } return dtos;
    }

    public List<Media> getAll() throws SQLException { return repo.getAll(); }
    public void delete(int id) throws SQLException { repo.delete(id); }
    public void update(int id, String title) throws SQLException { repo.update(id, title); }
    public void createPlaylist(String name) throws SQLException { repo.createPlaylist(name); }

    public String getStats() throws SQLException {
        List<Media> all = repo.getAll();
        return "Total Items: " + all.size() + " | Total Time: " + all.stream().mapToInt(Media::getDuration).sum() + "s";
    }
}