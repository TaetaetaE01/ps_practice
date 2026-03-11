import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0 && minHeap.isEmpty()) {
                minHeap.add(x);
                System.out.println(minHeap.poll());
            } else if (x == 0) {
                System.out.println(minHeap.poll());
            } else {
                minHeap.add(x);
            }
        }
    }
}