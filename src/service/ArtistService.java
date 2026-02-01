package service;

import model.Artist;
import repository.interfaces.ArtistRepositoryInterface;
import service.interfaces.ArtistServiceInterface;

import java.util.List;

public class ArtistService implements ArtistServiceInterface {

    private final ArtistRepositoryInterface repo;

    public ArtistService(ArtistRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public void addArtist(String name) {
        repo.create(name);
    }

    @Override
    public List<Artist> getAll() {
        return repo.getAll();
    }
}

