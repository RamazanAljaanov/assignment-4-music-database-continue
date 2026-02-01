package service;

import dto.MediaDTO;
import exception.InvalidInputException;
import model.Media;
import model.Podcast;
import model.Song;
import repository.interfaces.MediaRepositoryInterface;
import service.interfaces.MediaServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class MediaService implements MediaServiceInterface {

    private final MediaRepositoryInterface repo;

    public MediaService(MediaRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public int addMedia(Media m) {
        if (m == null) throw new InvalidInputException("Media is null");
        if (m.getTitle() == null || m.getTitle().trim().isEmpty())
            throw new InvalidInputException("Title empty!");
        if (m.getDuration() <= 0)
            throw new InvalidInputException("Duration must be > 0");

        return repo.addMedia(m);
    }

    @Override
    public List<MediaDTO> getAllAsDTO() {
        List<MediaDTO> dtos = new ArrayList<>();
        for (Media m : repo.getAll()) {
            MediaDTO d = new MediaDTO();
            d.id = m.getId();
            d.title = m.getTitle();

            if (m instanceof Song s) {
                d.info = (s.getArtist() != null) ? s.getArtist().getName() : "Unknown artist";
            } else if (m instanceof Podcast p) {
                d.info = p.getHost();
            } else {
                d.info = m.getMediaType();
            }

            dtos.add(d);
        }
        return dtos;
    }

    @Override
    public List<Media> getAll() {
        return repo.getAll();
    }

    @Override
    public void delete(int id) {
        if (id <= 0) throw new InvalidInputException("id must be > 0");
        repo.delete(id);
    }

    @Override
    public void updateTitle(int id, String title) {
        if (id <= 0) throw new InvalidInputException("id must be > 0");
        if (title == null || title.trim().isEmpty())
            throw new InvalidInputException("title empty");
        repo.updateTitle(id, title);
    }

    @Override
    public void createPlaylist(String name) {
        if (name == null || name.trim().isEmpty())
            throw new InvalidInputException("playlist name empty");
        repo.createPlaylist(name);
    }

    @Override
    public String getStats() {
        List<Media> all = repo.getAll();
        int total = all.stream().mapToInt(Media::getDuration).sum();
        return "Total Items: " + all.size() + " | Total Time: " + total + "s";
    }
}

