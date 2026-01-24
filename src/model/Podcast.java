package model;

public class Podcast extends Media {
    private String host;

    public Podcast(int id, String title, int duration, String host) {
        super(id, title, duration); // Вызов конструктора Media
        this.host = host;
    }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    @Override
    public String getMediaType() {
        return "Podcast";
    }

    @Override
    public void displayDetails() {
        System.out.println("[PODCAST] ID: " + getId() +
                " | Title: " + getTitle() +
                " | Host: " + host +
                " | Duration: " + (getDuration() / 60) + " min");
    }
}