class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        double dx12 = dots[1][0] - dots[0][0];
        double dy12 = dots[1][1] - dots[0][1];
        double slope12 = dy12 / dx12; 
        
        double dx34 = dots[3][0] - dots[2][0];
        double dy34 = dots[3][1] - dots[2][1];
        double slope34 = dy34 / dx34; 
        
        double dx13 = dots[2][0] - dots[0][0];
        double dy13 = dots[2][1] - dots[0][1];
        double slope13 = dy13 / dx13; 
        
        double dx24 = dots[3][0] - dots[1][0];
        double dy24 = dots[3][1] - dots[1][1];
        double slope24 = dy24 / dx24; 
        
        double dx14 = dots[3][0] - dots[0][0];
        double dy14 = dots[3][1] - dots[0][1];
        double slope14 = dy14 / dx14; 
        
        double dx23 = dots[2][0] - dots[1][0];
        double dy23 = dots[2][1] - dots[1][1];
        double slope23 = dy23 / dx23; 
        
        if (slope12 == slope34) {
            answer = 1;
            System.out.println(slope12 + " " + slope34);
        } else if (slope13 == slope24) {
            answer = 1;
            System.out.println(slope13 + " " + slope24);
        } else if (slope14 == slope23) {
            answer = 1;
            System.out.println(slope14 + " " + slope23);
        }
        
        return answer;
    }
}