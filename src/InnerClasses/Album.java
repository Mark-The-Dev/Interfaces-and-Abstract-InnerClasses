package InnerClasses;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();


    }

    public boolean addSong(String title, double duration){
        // Adds song and returns true if added

        return this.songs.add(new Song(title, duration));
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        // return true if exists and was added via track number
        Song checkedSong = this.songs.findSong(trackNumber);

        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }

        System.out.println("Track not found");
        return false;

    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        // return true if exists and was added by name.

        Song checkedSong = this.songs.findSong(title);

        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        return false;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song){

            //look for song, if not found add and return true;

           if (songs.contains(song)){
               return false;
           }
           this.songs.add(song);
           return true;
        }
       private Song findSong(String title){
            // look for song by title, if found, return it
           for (Song checkSong: this.songs){
               if (checkSong.getTitle().equals(title)){
                   return checkSong;
               }
           }
           return null;
       }

       private Song findSong(int trackNum){

            // search by number, if found, return

           int idx = trackNum - 1;

           if ((idx > 0) && idx < songs.size()){
                return songs.get(idx);
           }

           return null;
           }
       }



    }

