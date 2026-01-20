import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] memberList = new int[2][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            // 0은 몸무게 리스트
            // 1은 키 리스트
            memberList[0][i] = weight;
            memberList[1][i] = height;
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (memberList[0][i] < memberList[0][j] && memberList[1][i] < memberList[1][j]) {
                    rank++;
                }

            }
            System.out.print(rank + " ");
        }
    }
}