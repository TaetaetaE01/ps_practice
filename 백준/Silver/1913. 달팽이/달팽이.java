import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] snail = new int[n][n];
        // 밖에서 안으로 ) 달팽이 반시계방향 -> 아래, 오른, 위, 왼쪽
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = 0;

        int x = 0;
        int y = 0;
        int targetX = -1, targetY = -1;

        int num = n * n;

        while (num > 0) {
            snail[x][y] = num;

            if (num == target) {
                targetX = x;
                targetY = y;
            }

            num--;
            if (num == 0) {
                break;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // nx, ny 방향으로 이동해도 되는지
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || snail[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(snail[i][j] + " ");
            }
            sb.append("\n");
        }

        sb.append((targetX + 1) + " " + (targetY + 1));

        System.out.print(sb);

    }
}