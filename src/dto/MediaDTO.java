package dto;

public class MediaDTO {
    public int id;
    public String title;
    public String info;

    @Override
    public String toString() {
        return String.format("DTO -> ID: %d | Title: %s | Details: %s", id, title, info);
    }
}