import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0 && minHeap.isEmpty()) {
                minHeap.add(x);
                sb.append(minHeap.poll()).append('\n');
            } else if (x == 0) {
                sb.append(minHeap.poll()).append('\n');
            } else {
                minHeap.add(x);
            }
        }
        System.out.println(sb);
    }
}