import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N / 4; i++) {
			System.out.print("long ");
		}
		System.out.print("int");
    }
}