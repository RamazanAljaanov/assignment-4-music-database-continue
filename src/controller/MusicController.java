package controller;

import dto.MediaDTO;
import model.Artist;
import model.Media;
import service.interfaces.ArtistServiceInterface;
import service.interfaces.MediaServiceInterface;

import java.util.List;

public class MusicController {

    private final MediaServiceInterface mediaService;
    private final ArtistServiceInterface artistService;

    public MusicController(MediaServiceInterface mediaService, ArtistServiceInterface artistService) {
        this.mediaService = mediaService;
        this.artistService = artistService;
    }

    public void addArtist(String name) { artistService.addArtist(name); }
    public List<Artist> getArtists() { return artistService.getAll(); }

    public int addMedia(Media m) { return mediaService.addMedia(m); }
    public List<Media> getLibrary() { return mediaService.getAll(); }
    public List<MediaDTO> getDTOs() { return mediaService.getAllAsDTO(); }

    public void delete(int id) { mediaService.delete(id); }
    public void updateTitle(int id, String t) { mediaService.updateTitle(id, t); }
    public void createPlaylist(String n) { mediaService.createPlaylist(n); }
    public String getStats() { return mediaService.getStats(); }
}
