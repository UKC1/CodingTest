import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstTheta = Integer.parseInt(br.readLine());
        int secondTheta = Integer.parseInt(br.readLine());
        int thirdTheta = Integer.parseInt(br.readLine());
        if (firstTheta + secondTheta + thirdTheta != 180) {
            System.out.println("Error");
        } else if (firstTheta + secondTheta + thirdTheta == 180) {
            if (firstTheta == secondTheta && secondTheta == thirdTheta) {
                System.out.println("Equilateral");
            } else if (firstTheta != secondTheta && secondTheta != thirdTheta && firstTheta != thirdTheta) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        }
    }
}
