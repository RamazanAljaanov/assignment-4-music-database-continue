package repository.interfaces;


import model.Media;
import java.util.List;

public interface MediaRepositoryInterface {
    int addMedia(Media m);
    List<Media> getAll();
    void updateTitle(int id, String newTitle);
    void delete(int id);
    void createPlaylist(String name);
}


