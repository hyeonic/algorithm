package me.hyeonic.algorithm.programmers.level3.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers42579 {

    static class Song {
        private int id; // 고유번호
        private String genre; // 장르
        private int play; // 플레이 수

        public Song(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
    }

    public static List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, List<Song>> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            Song song = new Song(i, genres[i], plays[i]);
            List<Song> songs;
            if (genreMap.containsKey(genres[i])) {
                songs = genreMap.get(genres[i]);
            } else {
                songs = new ArrayList<>();
            }

            songs.add(song);
            genreMap.put(genres[i], songs);
        }

        List<String> genreKeySetList = new ArrayList<>(genreMap.keySet());
        Collections.sort(genreKeySetList, (x, y) -> {

            int totalPlayX = 0;
            List<Song> songs = genreMap.get(x);
            for (Song song : songs) {
                totalPlayX += song.play;
            }

            int totalPlayY = 0;
            songs = genreMap.get(y);
            for (Song song : songs) {
                totalPlayY += song.play;
            }

            if (totalPlayX < totalPlayY) return 1;
            else if (totalPlayX == totalPlayY) return 0;
            else return -1;
        });

        for (String key : genreKeySetList) {
            List<Song> songs = genreMap.get(key);
            Collections.sort(songs, (song1, song2) -> {
                if (song1.play < song2.play) return 1;
                else if (song1.play == song2.play) return 0;
                else return -1;
            });

            if (songs.size() >= 2) {
                for (int i = 0; i < 2; i++) {
                    answer.add(songs.get(i).id);
                }
            } else {
                answer.add(songs.get(0).id);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}));


        System.out.println(solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 500, 300, 2500}));

        System.out.println(solution(
                new String[]{"B", "A"},
                new int[]{500, 600}));

        System.out.println(solution(
                new String[]{"A", "B"},
                new int[]{600, 500}));

        System.out.println(solution(
                new String[]{"A", "A", "B", "A"},
                new int[]{2, 2, 2, 3}));

        System.out.println(solution(
                new String[]{"A", "A", "B", "A", "B", "B"},
                new int[]{5, 5, 6, 5, 7, 7}));
    }
}