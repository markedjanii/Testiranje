package org.example.testdome;

import java.util.HashSet;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        Song song = this;

        HashSet<String> s = new HashSet<>();
        s.add(song.name);

        for (Song curr=song.nextSong; curr != null; curr=curr.nextSong)
        {
            if (s.contains(curr.name))
                return true;

            s.add(curr.name);
        }

        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("Vino crveno");

        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(second);

        System.out.println(first.isInRepeatingPlaylist());
    }
}
