import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                int value = Integer.parseInt(input.split(" ")[1]);
                stack.push(value);
            } else if (input.startsWith("pop")) {
                // 스택이 비어있으면 NoSuchElementException 던져서 미리 체크
                if (stack.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(stack.pop() + "\n");
                }
            } else if (input.startsWith("size")) {
                sb.append(stack.size() + "\n");
            } else if (input.startsWith("empty")) {
                if (stack.isEmpty()) {
                    sb.append("1" + "\n");
                } else {
                    sb.append("0" + "\n");
                }
            } else if (input.startsWith("top")) {
                if (stack.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}