import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.startsWith("push")) {
                int value = Integer.parseInt(input.split(" ")[1]);
                queue.offer(value);
            } else if (input.startsWith("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else if (input.startsWith("size")) {
                sb.append(queue.size() + "\n");
            } else if (input.startsWith("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1" + "\n");
                } else {
                    sb.append("0" + "\n");
                }
            } else if (input.startsWith("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(queue.peek() + "\n");
                }
            } else if (input.startsWith("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(queue.peekLast() + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}