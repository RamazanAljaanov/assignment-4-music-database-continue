package controller;
import dto.MediaDTO;
import model.Media;
import service.*;
import java.util.List;

public class MusicController {
    private final MediaService mediaService = new MediaService();
    private final ArtistService artistService = new ArtistService();

    public void addArtist(String n) throws Exception { artistService.addArtist(n); }
    public List<model.Artist> getArtists() throws Exception { return artistService.getAll(); }
    public void addMedia(Media m) throws Exception { mediaService.addMedia(m); }
    public List<Media> getLibrary() throws Exception { return mediaService.getAll(); }
    public List<MediaDTO> getDTOs() throws Exception { return mediaService.getAllAsDTO(); }
    public void delete(int id) throws Exception { mediaService.delete(id); }
    public void update(int id, String t) throws Exception { mediaService.update(id, t); }
    public void createPlaylist(String n) throws Exception { mediaService.createPlaylist(n); }
    public String getStats() throws Exception { return mediaService.getStats(); }
}