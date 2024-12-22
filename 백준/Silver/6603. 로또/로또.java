import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!(str = br.readLine()).equals("0")) {
            String[] numbers = str.split(" ");
            int[] cards = new int[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                cards[i] = Integer.parseInt(numbers[i + 1]);
            }
            combination(cards, new int[6], 0, 0);
            System.out.println();
        }
    }

    static void combination(int[] cards, int[] arr, int index, int start) {
        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < cards.length; i++) {
            arr[index] = cards[i];
            combination(cards, arr, index + 1, i + 1);
        }
    }
}