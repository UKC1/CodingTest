import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        // 장르별 총 재생 횟수와 각 노래 정보 수집
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        // 각 장르별 노래 리스트를 재생 횟수와 인덱스 순으로 정렬
        for (List<Song> songs : songMap.values()) {
            songs.sort((a, b) -> b.plays != a.plays ? b.plays - a.plays : a.index - b.index);
        }

        // 장르를 총 재생 횟수에 따라 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        // 결과로 반환할 상위 두 곡의 인덱스 수집
        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = songMap.get(genre);
            int count = 0;
            for (Song song : songs) {
                if (count < 2) {
                    answerList.add(song.index);
                    count++;
                } else {
                    break;
                }
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    // 노래 정보를 저장하기 위한 도우미 클래스
    class Song {
        int index;
        int plays;

        Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}
