class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < spell.length; i++) {
        //     sb.append(spell[i]);    
        // }
        
        for (int i = 0; i < dic.length; i++) {
            int ck = 0;
            for (int j = 0; j < spell.length; j++) {
                if (dic[i].contains(spell[j])) {
                    ck++;
                } 
            }
         
            if (ck == spell.length) {
                answer = 1;
                break;
            }
            
        }
        return answer;
    }
}