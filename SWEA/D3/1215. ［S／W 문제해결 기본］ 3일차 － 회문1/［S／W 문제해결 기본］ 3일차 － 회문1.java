import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			int palindrome = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - N; j++) {
					String rowStr = "";
					String colStr = "";
					for (int k = 0; k < N; k++) {
						rowStr += arr[i][j + k];
						colStr += arr[j + k][i];
					}
					
					if(isPalindrome(rowStr)) palindrome++;
					if(isPalindrome(colStr)) palindrome++;
				}
			}
			System.out.println("#" + test_case + " " + palindrome);
		}
	}
	
	public static boolean isPalindrome(String str) {
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
		}
		return true;
	}
}