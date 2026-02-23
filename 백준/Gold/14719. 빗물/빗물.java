import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] blockList = new int[W];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blockList[i] = Integer.parseInt(st2.nextToken());
        }

        int result = 0;
        for (int i = 1; i < W - 1; i++) {
            // 양 끝에는 물이 들어갈 수 없다.
            int leftMax = 0;
            int rightMax = 0;

            // 왼쪽 벽 찾기
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, blockList[j]);
            }

            // 오른쪽 벽 찾기
            for (int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, blockList[j]);
            }

            // 왼쪽 벽, 오른쪽 벽 보다 낮아야 물이 고임
            if (blockList[i] < leftMax && blockList[i] < rightMax) {
                result += Math.min(leftMax, rightMax) - blockList[i];
            }
        }
        System.out.print(result);
    }


}