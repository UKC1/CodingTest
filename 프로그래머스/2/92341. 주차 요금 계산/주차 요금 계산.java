import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        // 기록 처리
        for (String record : records) {
            String[] carInfo = record.split(" ");
            String carNum = carInfo[1];
            int hour = Integer.parseInt(carInfo[0].substring(0, 2));
            int min = Integer.parseInt(carInfo[0].substring(3, 5));
            int time = hour * 60 + min;
            String state = carInfo[2];
            
            if (state.equals("IN")) {
                inTimeMap.put(carNum, time);
            } else {
                int inTime = inTimeMap.remove(carNum);
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + (time - inTime));
            }
        }
        
        // 출차 기록이 없는 차량 처리
        for (String carNum : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNum);
            int endTime = 23 * 60 + 59;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + (endTime - inTime));
        }
        
        // 요금 계산
        Map<String, Integer> feeMap = new TreeMap<>();
        for (String carNum : totalTimeMap.keySet()) {
            feeMap.put(carNum, calculateFee(fees, totalTimeMap.get(carNum)));
        }
        
        // 결과 배열 생성
        int[] answer = new int[feeMap.size()];
        int idx = 0;
        for (int fee : feeMap.values()) {
            answer[idx++] = fee;
        }
        
        return answer;
    }
    
    private int calculateFee(int[] fees, int time) {
        int initTime = fees[0];
        int initFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (time <= initTime) {
            return initFee;
        } else {
            return initFee + (int) Math.ceil((time - initTime) / (double) unitTime) * unitFee;
        }
    }
}
