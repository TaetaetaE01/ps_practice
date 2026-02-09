import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n];
        Arrays.fill(line, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int tallNum = 0; tallNum < n; tallNum++) {
            int leftTall = Integer.parseInt(st.nextToken());

            // leftTall 왼쪽에 큰 사람
            // 줄에 -1이 있어야 사람이 설 수 있음
            // 옆에 빈칸 count가 즉 leftTall(왼쪽에 키 큰 사람이 있는 수)
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (line[i] == -1) {
                    if (count == leftTall) {
                        line[i] = tallNum;
//                        continue;
                    }
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(line[i] + 1 + " ");
        }
        System.out.print(sb);
    }
}