import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C= Integer.parseInt(br.readLine());
        int sum = A + B - C;
        String str = String.valueOf(A) + String.valueOf(B);
        int nextSum = Integer.parseInt(str) - C;
        System.out.println(sum);
        System.out.println(nextSum);
   }
}