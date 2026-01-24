import controller.MusicController;
import model.*;
import exception.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicController controller = new MusicController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MUSIC MANAGEMENT ---");
            System.out.println("1. Add Artist | 2. Show Artists | 3. Add Song | 4. Show Library (Polymorphism)");
            System.out.println("5. Show DTOs | 6. Update Title | 7. Delete | 8. Stats | 9. Create Playlist | 0. Exit");
            System.out.print("> ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: System.out.print("Name: "); controller.addArtist(sc.nextLine()); break;
                    case 2: controller.getArtists().forEach(a -> System.out.println("ID: " + a.getId() + " | " + a.getName())); break;
                    case 3:
                        System.out.print("Title: "); String t = sc.nextLine();
                        System.out.print("Dur(s): "); int d = Integer.parseInt(sc.nextLine());
                        System.out.print("Genre: "); String g = sc.nextLine();
                        System.out.print("Artist ID: "); int aid = Integer.parseInt(sc.nextLine());
                        controller.addMedia(new Song(0, t, d, g, new Artist(aid, "")));
                        break;
                    case 4: controller.getLibrary().forEach(Media::displayDetails); break;
                    case 5: controller.getDTOs().forEach(System.out::println); break;
                    case 6: System.out.print("ID: "); int uid = Integer.parseInt(sc.nextLine());
                        System.out.print("New Title: "); controller.update(uid, sc.nextLine()); break;
                    case 7: System.out.print("ID: "); controller.delete(Integer.parseInt(sc.nextLine())); break;
                    case 8: System.out.println(controller.getStats()); break;
                    case 9: System.out.print("P-Name: "); controller.createPlaylist(sc.nextLine()); break;
                    case 0: return;
                }
            } catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
        }
    }
}