import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();
        
        // 각 장르별 총 재생 횟수 계산 및 노래를 우선순위 큐에 저장
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            genreSongs.putIfAbsent(genres[i], new PriorityQueue<>((a, b) -> a.plays == b.plays ? a.index - b.index : b.plays - a.plays));
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 장르를 총 재생 횟수에 따라 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> answerList = new ArrayList<>();
        // 각 장르별로 가장 많이 재생된 두 곡 선택
        for (String genre : sortedGenres) {
            PriorityQueue<Song> queue = genreSongs.get(genre);
            int count = 0;
            while (!queue.isEmpty() && count < 2) {
                answerList.add(queue.poll().index);
                count++;
            }
        }

        // 리스트를 배열로 변환
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
