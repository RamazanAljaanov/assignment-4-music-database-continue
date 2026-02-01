package repository.interfaces;

import model.Artist;
import java.util.List;

public interface ArtistRepositoryInterface extends CrudRepository<Artist> {
    void create(String name);
    List<Artist> getAll();
}

