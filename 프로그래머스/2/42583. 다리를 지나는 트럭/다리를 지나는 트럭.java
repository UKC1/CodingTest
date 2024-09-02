import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitTrucksQ = new ArrayDeque<>();
        for (int truck : truck_weights) {
            waitTrucksQ.offer(truck);
        }
        int remainWeight = weight;
        int time = 0;
        Queue<Integer> moveTrucksQ = new ArrayDeque<>();
        Queue<Integer> moveTrucksTimeQ = new ArrayDeque<>();
        Queue<Integer> arriveTrucksQ = new ArrayDeque<>();
        while (arriveTrucksQ.size() < truck_weights.length) {
            // 시간이 1초 지날 때 1만큼 이동
            time++;
            // 들어간 시간차가 다리길이면 도착!
            if (!moveTrucksQ.isEmpty()) {
                int truckTime = time - moveTrucksTimeQ.peek();
                if (truckTime / bridge_length == 1) {
                    int arriveTruck = moveTrucksQ.poll();
                    moveTrucksTimeQ.poll();
                    arriveTrucksQ.offer(arriveTruck);
                    remainWeight += arriveTruck;
                }
            }
            // 다리 길이 또는 무게가 이하면 추가
            if (!waitTrucksQ.isEmpty() && moveTrucksQ.size() <= bridge_length && remainWeight >= waitTrucksQ.peek()) {
                int currentTruck = waitTrucksQ.poll();
                moveTrucksQ.offer(currentTruck);
                moveTrucksTimeQ.offer(time);
                remainWeight -= currentTruck;
            }
        
        }
        return time;
    }
}