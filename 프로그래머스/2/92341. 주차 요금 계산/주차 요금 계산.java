import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalParkingTime = new HashMap<>();
        Map<String, Integer> inTimeMap = new HashMap<>();
        
        for (String record : records) {
            String[] carInfo = record.split(" ");
            String carNum = carInfo[1];
            int hour = Integer.parseInt(carInfo[0].substring(0, 2));
            int min = Integer.parseInt(carInfo[0].substring(3, 5));
            int time = hour * 60 + min;
            String status = carInfo[2];
            
            if (status.equals("IN")) {
                inTimeMap.put(carNum, time);
            } else if (status.equals("OUT")) {
                int inTime = inTimeMap.remove(carNum);
                totalParkingTime.put(carNum, totalParkingTime.getOrDefault(carNum, 0) + (time - inTime));
            }
        }
        
        // 출차 기록이 없는 차량에 대해 23:59 출차 처리
        for (String carNum : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNum);
            int endTime = 23 * 60 + 59;
            totalParkingTime.put(carNum, totalParkingTime.getOrDefault(carNum, 0) + (endTime - inTime));
        }
        
        // 요금 계산
        Map<String, Integer> feeMap = new TreeMap<>();
        for (String carNum : totalParkingTime.keySet()) {
            int parkingTime = totalParkingTime.get(carNum);
            feeMap.put(carNum, calculateFee(fees, parkingTime));
        }
        
        // 결과 배열 생성
        int[] answer = new int[feeMap.size()];
        int idx = 0;
        for (int fee : feeMap.values()) {
            answer[idx++] = fee;
        }
        
        return answer;
    }
    
    public int calculateFee(int[] fees, int time) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (time <= basicTime) {
            return basicFee;
        } else {
            int extraTime = time - basicTime;
            int extraUnits = (int) Math.ceil((double) extraTime / unitTime);
            return basicFee + extraUnits * unitFee;
        }
    }
}
