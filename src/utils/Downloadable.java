package utils;

public interface Downloadable {
    void download();

    default String defaultQuality() {
        return "320kbps";
    }

    static boolean isDownloadable(Object o) {
        return o instanceof Downloadable;
    }
}

