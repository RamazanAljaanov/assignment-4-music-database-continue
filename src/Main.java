import controller.MusicController;
import model.*;
import repository.ArtistRepository;
import repository.MediaRepository;
import repository.interfaces.ArtistRepositoryInterface;
import repository.interfaces.MediaRepositoryInterface;
import service.ArtistService;
import service.MediaService;
import service.interfaces.ArtistServiceInterface;
import service.interfaces.MediaServiceInterface;
import utils.ReflectionUtils;
import utils.SortingUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ===== Manual DI =====
        MediaRepositoryInterface mediaRepo = new MediaRepository();
        ArtistRepositoryInterface artistRepo = new ArtistRepository();

        MediaServiceInterface mediaService = new MediaService(mediaRepo);
        ArtistServiceInterface artistService = new ArtistService(artistRepo);

        MusicController controller = new MusicController(mediaService, artistService);
        // =====================

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MUSIC MANAGEMENT ---");
            System.out.println("1. Add Artist | 2. Show Artists | 3. Add Song | 4. Show Library (Polymorphism)");
            System.out.println("5. Show DTOs | 6. Update Title | 7. Delete | 8. Stats | 9. Create Playlist");
            System.out.println("10. Reflection Demo | 11. Sort Library Demo | 0. Exit");
            System.out.print("> ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Name: ");
                        controller.addArtist(sc.nextLine());
                    }
                    case 2 -> controller.getArtists()
                            .forEach(a -> System.out.println("ID: " + a.getId() + " | " + a.getName()));

                    case 3 -> {
                        System.out.print("Title: ");
                        String t = sc.nextLine();
                        System.out.print("Dur(s): ");
                        int d = Integer.parseInt(sc.nextLine());
                        System.out.print("Genre: ");
                        String g = sc.nextLine();
                        System.out.print("Artist ID: ");
                        int aid = Integer.parseInt(sc.nextLine());

                        controller.addMedia(new Song(0, t, d, g, new Artist(aid, "")));
                    }

                    case 4 -> controller.getLibrary().forEach(Media::displayDetails);

                    case 5 -> controller.getDTOs().forEach(System.out::println);

                    case 6 -> {
                        System.out.print("ID: ");
                        int uid = Integer.parseInt(sc.nextLine());
                        System.out.print("New Title: ");
                        controller.updateTitle(uid, sc.nextLine());
                    }

                    case 7 -> {
                        System.out.print("ID: ");
                        controller.delete(Integer.parseInt(sc.nextLine()));
                    }

                    case 8 -> System.out.println(controller.getStats());

                    case 9 -> {
                        System.out.print("P-Name: ");
                        controller.createPlaylist(sc.nextLine());
                    }

                    case 10 -> {
                        // Reflection output for README screenshot
                        ReflectionUtils.inspect(Song.class);
                    }

                    case 11 -> {
                        List<Media> lib = controller.getLibrary();
                        SortingUtils.sortByDurationDesc(lib);
                        lib.forEach(Media::displayDetails);
                    }

                    case 0 -> { return; }

                    default -> System.out.println("Unknown option!");
                }

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
