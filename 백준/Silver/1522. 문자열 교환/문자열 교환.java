import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int aCount = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCount++;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            int bCount = 0;
            for (int j = i; j < aCount+i; j++) {
                int windowIndex = j;
                if (windowIndex >= str.length()) {
                    windowIndex = windowIndex % str.length();
                }
                if (str.charAt(windowIndex) == 'b') {
                    bCount++;
                }
            }
            result = Math.min(result, bCount);
        }
        System.out.print(result);
    }
}