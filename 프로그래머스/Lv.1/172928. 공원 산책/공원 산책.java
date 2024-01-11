class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int count = Integer.parseInt(routes[i].split(" ")[1]);
            char c = park[answer[0]].charAt(answer[1]);
            int ck = 0;
            
            if (direction.equals("E")) {
                for (int j = 0; j < count; j++) {
                    if (answer[1] + 1 < park[0].length()) {
                        answer[1]++;
                        ck++;
                        c = park[answer[0]].charAt(answer[1]);
                        if (c == 'X') {
                            answer[1] -= ck;
                            break;
                        }
                    } else {
                        answer[1] -= ck;
                        break;
                    }
                }
            } else if (direction.equals("W")) {
                for (int j = count - 1; j >= 0; j--) {
                    if (answer[1] - 1 >= 0) {
                        answer[1]--;
                        ck++;
                        c = park[answer[0]].charAt(answer[1]);
                        if (c == 'X') {
                            answer[1] += ck;
                            break;
                        }
                    } else {
                        answer[1] += ck;
                        break;
                    }
                }
            } else if (direction.equals("S")) {
                 for (int j = 0; j < count; j++) {
                    if (answer[0] + 1 < park.length) {
                        answer[0]++;
                        ck++;
                        c = park[answer[0]].charAt(answer[1]);
                        if (c == 'X') {
                            answer[0] -= ck;
                            break;
                        }
                    } else {
                        answer[0] -= ck;
                        break;
                    }
                }
            } else if (direction.equals("N")) {
                for (int j = count - 1; j >= 0; j--) {
                    if (answer[0] - 1 >= 0) {
                        answer[0]--;
                        ck++;
                        c = park[answer[0]].charAt(answer[1]);
                        if (c == 'X') {
                            answer[0] += ck;
                            break;
                        }
                    } else {
                        answer[0] += ck;
                        break;
                    }
                }
            } 
            
        }
        return answer;
    }
}