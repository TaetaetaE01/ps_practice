import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }

            int[] alphabet = new int[26];
            for (int j = 0; j < W.length(); j++) {
                alphabet[W.charAt(j) - 'a']++;
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < W.length(); j++) {
                // 조건에 맞는 것이 없을 때
                if (alphabet[W.charAt(j) - 'a'] < K) {
                    continue;
                }
                int count = 1;
                for (int k = j + 1; k < W.length(); k++) {
                    // 조건 충족해서 탐색시작 /  k개 만큼 있는 걸 찾아야됨
                    // j랑 같은 알파벳을 찾고, 그 길이가 최솟 값인 녀석을 min에 넣는다
                    if (W.charAt(j) - 'a' == W.charAt(k) - 'a') {
                        count++;
                        if (count == K) {
                            min = Math.min(min, k - j + 1);
                            max = Math.max(max, k - j + 1);
                            break;
                        }

                    }
                }
            }
            if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(min + " " + max + "\n");
            }
        }
        System.out.print(sb);
    }
}