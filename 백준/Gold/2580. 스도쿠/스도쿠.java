import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹을 통해 스도쿠 풀기 시작
        solveSudoku(0, 0);
    }

    // 스도쿠를 푸는 백트래킹 메서드
    public static boolean solveSudoku(int row, int col) {
        // 모든 행을 다 채우면 종료
        if (row == 9) {
            printSudoku(); // 정답 출력
            return true;
        }

        // 마지막 열까지 다 채웠다면 다음 행으로 이동
        if (col == 9) {
            return solveSudoku(row + 1, 0);
        }

        // 현재 칸이 이미 숫자가 채워져 있으면 다음 칸으로 이동
        if (sudoku[row][col] != 0) {
            return solveSudoku(row, col + 1);
        }

        // 1부터 9까지 숫자를 넣어보고, 유효하면 재귀 호출
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                sudoku[row][col] = num; // 숫자를 넣음
                if (solveSudoku(row, col + 1)) { // 다음 칸으로 이동
                    return true;
                }
                sudoku[row][col] = 0; // 실패하면 다시 0으로 리셋
            }
        }

        return false; // 어떤 숫자도 넣을 수 없는 경우 false 반환
    }

    // 스도쿠 규칙에 맞는지 확인하는 메서드
    public static boolean isValid(int row, int col, int num) {
        // 가로, 세로 확인
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num || sudoku[i][col] == num) {
                return false;
            }
        }

        // 3x3 박스 확인
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // 조건을 모두 통과하면 true 반환
    }

    // 스도쿠를 출력하는 메서드
    public static void printSudoku() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}