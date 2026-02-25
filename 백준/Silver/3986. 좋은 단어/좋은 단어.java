import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int goodWordCount = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                goodWordCount++;
            }
        }
        System.out.print(goodWordCount);
    }
}