import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] point = {3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> map = new HashMap();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        for(int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + point[choices[i] - 1]);
            } else if (choices[i] > 4) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + point[choices[i] - 1]);
            } 
        }
       
        String answer = "";
        if (map.get('R') > map.get('T')) {
            answer += 'R';
        } else if (map.get('R') < map.get('T')) {
            answer += 'T';
        } else {
            answer += 'R';
        }
        
        if (map.get('C') > map.get('F')) {
            answer += 'C';
        } else if (map.get('C') < map.get('F')) {
            answer += 'F';
        } else {
            answer += 'C';
        }
        
        if (map.get('J') > map.get('M')) {
            answer += 'J';
        } else if (map.get('J') < map.get('M')) {
            answer += 'M';
        } else {
            answer += 'J';
        }
        
        if (map.get('A') > map.get('N')) {
            answer += 'A';
        } else if (map.get('A') < map.get('N')) {
            answer += 'N';
        } else {
            answer += 'A';
        }
    
        return answer;
    }
}