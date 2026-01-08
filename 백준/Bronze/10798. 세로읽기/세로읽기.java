import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] word = new int[5][15];
        for (int row = 0; row < 5; row++) {
            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                word[row][i] = line.charAt(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word[0].length; i++) {
            for (int row = 0; row < 5; row++) {
                if (word[row][i] == 0) {
                    continue;
                }
                sb.append((char) word[row][i]);
            }
        }
        System.out.print(sb);
    }
}