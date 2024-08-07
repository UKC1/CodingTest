import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = br.readLine().toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if(!set.remove(arr[i])) {
                    set.add(arr[i]);
                }
            }
            System.out.println("#" + test_case + " " + set.size());
        }
    }
}