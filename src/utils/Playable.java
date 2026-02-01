package utils;

public interface Playable {
    void play();

    default void stopPlaying() {
        System.out.println("Stopped playing.");
    }

    static boolean isPlayable(Object o) {
        return o instanceof Playable;
    }
}
