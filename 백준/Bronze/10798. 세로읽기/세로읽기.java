import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = str[j];
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j][i] != null ? arr[j][i] : "");
            }
        }
    }
}