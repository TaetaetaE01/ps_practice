import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 횟수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 배열 크기
            int d = Integer.parseInt(st.nextToken()); // 회전 각도

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            if (d < 0) {
                d += 360;
            }
            d /= 45;

            int[][] result = matrix;
            for (int r = 0; r < d; r++) {
                result = rotate(result);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(result[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    private static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int mid = n / 2;

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            result[i] = matrix[i].clone();
        }

        for (int i = 0; i < n; i++) {
            // 주 대각선 -> 가운데 열
            result[i][mid] = matrix[i][i];

            // 가운데 열 -> 부 대각선
            result[i][n - 1 - i] = matrix[i][mid];

            // 부 대각선 -> 가운데 헹
            result[mid][n - 1 - i] = matrix[i][n - 1 - i];

            // 가운데 행 -> 주 대각선
            result[i][i] = matrix[mid][i];
        }
        return result;
    }
}