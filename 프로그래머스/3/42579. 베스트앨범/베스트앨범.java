import java.util.*;

class Solution {
    class Song {
        int idx;
        int playCnt;
        Song() {}
        Song(int idx, int playCnt) {
            this.idx = idx;
            this.playCnt = playCnt;
        }
        
        public String toString() {
            return "idx " + idx + " playCnt " + playCnt;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 속한 노래 카운트
        Map<String, Integer> genrePlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 2. 장르별 곡들 수록
        Map<String, List<Song>> sameGenreSongs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (sameGenreSongs.get(genres[i]) == null) {
                List<Song> songList = new ArrayList<>();
                songList.add(new Song(i, plays[i]));
                sameGenreSongs.put(genres[i], songList);
            } else {
                sameGenreSongs.get(genres[i]).add(new Song(i, plays[i]));
            }
        }
        
        // 3. 장르 내 곡들 재생횟수 기준으로 내림차순 정렬 같으면 고유 번호가 오름차순으로 정렬
        for (List<Song> list : sameGenreSongs.values()) {
            Collections.sort(list, Comparator
                    .comparingInt((Song s) -> -s.playCnt)
                    .thenComparingInt(s -> s.idx));
        }
        
        int[] arr = new int[genrePlays.size()];
        int idx = 0;
        for (Integer cntNum : genrePlays.values()) {
            arr[idx++] = cntNum;
        }
        
        Arrays.sort(arr);
        List<Integer> idxList = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            String checkStr = "";
            for (String genre : genrePlays.keySet()) {
                if (genrePlays.get(genre) == arr[i]) {
                    checkStr = genre;
                    break;
                } 
            }
            
            int cnt = 2;
            for (Song song : sameGenreSongs.get(checkStr)) {
                if (cnt == 0) break;
                idxList.add(song.idx);
                cnt--;
            }
        }
        
        int[] answer = new int[idxList.size()];
        for (int i = 0; i < idxList.size(); i++) {
            answer[i] = idxList.get(i);
        }
        // System.out.println(idxList);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(genrePlays);
        // System.out.println(sameGenreSongs);
        
        return answer;
    }
}