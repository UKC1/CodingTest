import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageReached = new int[N + 1];
        for (int stage : stages) {
            if (stage <= N) {
                stageReached[stage]++;
            }
        }
        
        int totalPlayers = stages.length;
        StageFailure[] failures = new StageFailure[N];
        for (int i = 0; i < N; i++) {
            double failureRate = totalPlayers > 0 ? (double)stageReached[i + 1] / totalPlayers : 0;
            failures[i] = new StageFailure(i + 1, failureRate);
            totalPlayers -= stageReached[i + 1];
        }
        
        Arrays.sort(failures, Comparator.comparingDouble(StageFailure::getFailureRate).reversed());
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failures[i].stage;
        }
        
        return answer;
    }

    static class StageFailure {
        int stage;
        double failureRate;

        StageFailure(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }

        double getFailureRate() {
            return failureRate;
        }
    }
}
