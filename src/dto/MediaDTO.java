package dto;

public class MediaDTO {
    public int id;
    public String title;
    public String info; // ТО САМОЕ ПОЛЕ, КОТОРОГО НЕ ХВАТАЛО

    @Override
    public String toString() {
        // Красивый вывод в консоль для Main
        return String.format("DTO -> ID: %d | Title: %s | Details: %s", id, title, info);
    }
}