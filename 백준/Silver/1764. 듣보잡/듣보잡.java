import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> result = new ArrayList<>();

        Set<String> noListenList = new HashSet<>();
        for (int i = 0; i < N; i++) {
            noListenList.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String noWatchName = br.readLine();
            if (noListenList.contains(noWatchName)) {
                result.add(noWatchName);
            }
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (String resultName : result) {
            sb.append(resultName).append('\n');
        }
        System.out.print(sb);
    }
}