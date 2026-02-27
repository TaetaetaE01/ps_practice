import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st2.nextToken());
            if (!(value > C)) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, new Comparator<Integer>() {
            // value에 대해 내림차순 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int key : keySetList) {
            int loop = map.get(key);
            while (loop > 0) {
                sb.append(key + " ");
                loop--;
            }
        }
        System.out.print(sb);
    }
}