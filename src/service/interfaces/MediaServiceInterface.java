package service.interfaces;

import dto.MediaDTO;
import model.Media;

import java.util.List;

public interface MediaServiceInterface {
    int addMedia(Media m);
    List<Media> getAll();
    List<MediaDTO> getAllAsDTO();
    void delete(int id);
    void updateTitle(int id, String title);
    void createPlaylist(String name);
    String getStats();
}

