import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cowMoveList = new int[11];
        Arrays.fill(cowMoveList, -1);

        int totalMove = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cowNo = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (cowMoveList[cowNo] == -1) {
                cowMoveList[cowNo] = position;
            } else if (cowMoveList[cowNo] != position) {
                cowMoveList[cowNo] = position;
                totalMove++;
            }
        }
        System.out.print(totalMove);
    }
}