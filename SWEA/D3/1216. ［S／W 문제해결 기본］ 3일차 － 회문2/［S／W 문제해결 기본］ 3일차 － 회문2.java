import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스 번호 읽기
            int maxLen = 0; // 가장 긴 회문의 길이 초기화
 
            char[][] arr = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
 
            // 행과 열에서 가장 긴 회문 찾기
            for (int i = 0; i < 100; i++) {
                maxLen = Math.max(maxLen, findLongestPalindrome(arr[i])); // 행
                maxLen = Math.max(maxLen, findLongestPalindrome(getColumn(arr, i))); // 열
            }
 
            System.out.println("#" + N + " " + maxLen);
        }
    }
 
    // 주어진 배열에서 가장 긴 회문 찾기 (동적 계획법 사용)
    public static int findLongestPalindrome(char[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
 
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
 
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (arr[start] == arr[end]) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        maxLen = Math.max(maxLen, end - start + 1);
                    }
                }
            }
        }
 
        return maxLen;
    }
 
    // 주어진 2차원 배열에서 특정 열을 추출하여 배열로 반환
    public static char[] getColumn(char[][] arr, int colIndex) {
        char[] col = new char[100];
        for (int i = 0; i < 100; i++) {
            col[i] = arr[i][colIndex];
        }
        return col;
    }
}