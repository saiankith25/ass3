package fr.isep.ii3510.assignment3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Band implements Serializable {
    @Override
    public String toString() {
        return "Band{" +
                "bandName='" + bandName + '\'' +
                ", albumSongs=" + albumSongs +
                '}';
    }

    private String bandName;

    private HashMap<String,ArrayList<String>> albumSongs = new HashMap<String, ArrayList<String>>();

    public Band(String bandName, HashMap<String, ArrayList<String>> albumSongs) {
        this.bandName = bandName;
        this.albumSongs = albumSongs;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public HashMap<String, ArrayList<String>> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(HashMap<String, ArrayList<String>> albumSongs) {
        this.albumSongs = albumSongs;
    }
}
