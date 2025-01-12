import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            long num = Long.parseLong(st.nextToken());
            sum += num * num;
        } 
        System.out.print(sum % 10);
    }
}