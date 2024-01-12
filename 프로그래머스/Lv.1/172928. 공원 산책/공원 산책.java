class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] position = new int[2]; // 현재 위치
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    position[0] = i;
                    position[1] = j;
                    break;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int count = Integer.parseInt(parts[1]);
            move(park, position, direction, count);
        }

        return position;
    }

    private void move(String[] park, int[] position, String direction, int count) {
        int originalRow = position[0];
        int originalCol = position[1];
        int tempRow = position[0];
        int tempCol = position[1];
        int rowLength = park.length;
        int colLength = park[0].length();

        for (int i = 0; i < count; i++) {
            switch (direction) {
                case "E":
                    if (tempCol + 1 < colLength && park[tempRow].charAt(tempCol + 1) != 'X') tempCol++;
                    else {
                        position[0] = originalRow;
                        position[1] = originalCol;
                        return;
                    }
                    break;
                case "W":
                    if (tempCol - 1 >= 0 && park[tempRow].charAt(tempCol - 1) != 'X') tempCol--;
                    else {
                        position[0] = originalRow;
                        position[1] = originalCol;
                        return;
                    }
                    break;
                case "S":
                    if (tempRow + 1 < rowLength && park[tempRow + 1].charAt(tempCol) != 'X') tempRow++;
                    else {
                        position[0] = originalRow;
                        position[1] = originalCol;
                        return;
                    }
                    break;
                case "N":
                    if (tempRow - 1 >= 0 && park[tempRow - 1].charAt(tempCol) != 'X') tempRow--;
                    else {
                        position[0] = originalRow;
                        position[1] = originalCol;
                        return;
                    }
                    break;
            }
        }
        
        // 이동 성공적으로 마친 경우, 위치 업데이트
        position[0] = tempRow;
        position[1] = tempCol;
    }
}
