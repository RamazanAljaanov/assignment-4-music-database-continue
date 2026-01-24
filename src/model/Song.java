package model;
import utils.*;

public class Song extends Media implements Playable, Downloadable {
    private String genre;
    private Artist artist; // КОМПОЗИЦИЯ (один объект внутри другого)

    public Song(int id, String title, int duration, String genre, Artist artist) {
        super(id, title, duration);
        this.genre = genre;
        this.artist = artist;
    }
    public String getGenre() { return genre; }
    public Artist getArtist() { return artist; }

    @Override public String getMediaType() { return "Song"; }
    @Override public void displayDetails() {
        System.out.println("[SONG] ID: " + getId() + " | Title: " + getTitle() + " | Artist: " + (artist != null ? artist.getName() : "N/A") + " | Genre: " + genre);
    }
    @Override public void play() { System.out.println("Playing song: " + getTitle()); }
    @Override public void download() { System.out.println("Downloading song..."); }
}