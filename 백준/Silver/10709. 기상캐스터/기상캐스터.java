import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] regions = new int[h][w];
        for (int height = 0; height < h; height++) {
            String inputLine = br.readLine();
            for (int width = 0; width < w; width++) {

                if (inputLine.charAt(width) == 'c') {
                    regions[height][width] = 0;
                } else {
                    regions[height][width] = -1;
                }
            }
        }

        for (int height = 0; height < h; height++) {
            for (int width = 0; width < w; width++) {

                int cloudTime = 1;
                if (regions[height][width] == 0) {
                    for (int i = width + 1; i < w; i++) {
                        if (regions[height][i] != 0) {
                            regions[height][i] = cloudTime;
                            cloudTime++;
                        }
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int height = 0; height < h; height++) {
            for (int width = 0; width < w; width++) {
                sb.append(regions[height][width] + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}