package model;
public abstract class Media {
    private int id;
    private String title;
    private int duration;

    public Media(int id, String title, int duration) {
        this.id = id; this.title = title; this.duration = duration;
    }
    // Геттеры и сеттеры (Инкапсуляция)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getDuration() { return duration; }

    // Требование: 2 абстрактных метода
    public abstract String getMediaType();
    public abstract void displayDetails();

    // Требование: 1 конкретный метод
    public void stop() { System.out.println("Stopping " + title); }
}