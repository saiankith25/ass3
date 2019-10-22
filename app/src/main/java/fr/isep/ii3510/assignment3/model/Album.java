package fr.isep.ii3510.assignment3.model;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {
    public Album(String name, List<String> songs_list) {
        this.name = name;
        this.songs_list = songs_list;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", songs_list=" + songs_list +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSongs_list() {
        return songs_list;
    }

    public void setSongs_list(List<String> songs_list) {
        this.songs_list = songs_list;
    }

    private String name;
    private List<String> songs_list;

}
