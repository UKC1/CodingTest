import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> gradeScore = new HashMap<String, Double>();
        gradeScore.put("A+", 4.5);
        gradeScore.put("A0", 4.0);
        gradeScore.put("B+", 3.5);
        gradeScore.put("B0", 3.0);
        gradeScore.put("C+", 2.5);
        gradeScore.put("C0", 2.0);
        gradeScore.put("D+", 1.5);
        gradeScore.put("D0", 1.0);
        gradeScore.put("F", 0.0);
        double totalClassDays = 0;
        double totalScore = 0;
        for (int i = 0; i < 20; i++) {
            String[] content = br.readLine().split(" ");
            if (content[2].equals("P")) continue;
            double classDay = Double.parseDouble(content[1]);
            double score = gradeScore.get(content[2]) ;
            totalClassDays += classDay;
            totalScore += score * classDay;
        }

        System.out.printf("%.6f", totalScore / totalClassDays);
    }
}