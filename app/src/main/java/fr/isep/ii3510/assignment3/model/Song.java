package fr.isep.ii3510.assignment3.model;

import java.io.Serializable;

public class Song implements Serializable {

    private String songName;

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                '}';
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Song(String songName) {
        this.songName = songName;
    }
}
