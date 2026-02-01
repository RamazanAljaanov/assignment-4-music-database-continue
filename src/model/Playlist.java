package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private List<Media> items;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;;
        this.items = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Media> getItems() { return items; }

    public void addItem(Media media) { items.add(media); }
}
