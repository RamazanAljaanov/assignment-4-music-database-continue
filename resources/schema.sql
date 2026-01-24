CREATE TABLE artists (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE media (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    duration_sec INT NOT NULL CHECK (duration_sec > 0)
);

CREATE TABLE songs (
    media_id INT PRIMARY KEY REFERENCES media(id) ON DELETE CASCADE,
    artist_id INT REFERENCES artists(id) ON DELETE SET NULL,
    genre VARCHAR(50)
);

CREATE TABLE podcasts (
    media_id INT PRIMARY KEY REFERENCES media(id) ON DELETE CASCADE,
    host_name VARCHAR(100)
);

CREATE TABLE playlists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE playlist_media (
    playlist_id INT REFERENCES playlists(id) ON DELETE CASCADE, media_id INT REFERENCES media(id) ON DELETE CASCADE, PRIMARY KEY (playlist_id, media_id));