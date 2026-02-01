package model;
public abstract class Media {
    private int id;
    private String title;
    private int duration;

    public Media(int id, String title, int duration) {
        this.id = id; this.title = title; this.duration = duration;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getDuration() { return duration; }


    public abstract String getMediaType();
    public abstract void displayDetails();

    public void stop() { System.out.println("Stopping " + title); }
}