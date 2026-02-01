package service.interfaces;
import service.interfaces.ArtistServiceInterface;

import model.Artist;
import java.util.List;

public interface ArtistServiceInterface {
    void addArtist(String name);
    List<Artist> getAll();
}
