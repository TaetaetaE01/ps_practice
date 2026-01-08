import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] result = new int[26];
            String s = br.readLine();
            s = s.replace(" ", "");

            for (int j = 0; j < s.length(); j++) {
                result[s.charAt(j) - 'a']++;
            }

            int max = -1;
            int maxIndex = -1;
            int maxCount = 0;
            for (int t = 0; t < 26; t++) {
                int r = result[t];
                if (r > max) {
                    max = r;
                    maxIndex = t;
                    maxCount = 1;
                } else if (r == max) {
                    maxCount++;
                }
            }
            if (maxCount > 1) {
                System.out.println("?");
            } else if (maxCount == 1) {
                System.out.println((char) (maxIndex + 'a'));
            }
        }
    }
}