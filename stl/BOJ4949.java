package stl;

import java.util.*;
import java.io.*;

/// https://www.acmicpc.net/problem/4949
public class BOJ4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        loop: while(true) {
            str = br.readLine();
            if(".".equals(str))
                break;
            Stack<Integer> que = new Stack<>();
            for(char c : str.toCharArray()) {
                switch (c) {
                    case '(':
                        que.add(1);
                        break;
                    case ')':
                        if(que.isEmpty() || que.peek() != 1) {
                            sb.append("no\n");
                            continue loop;
                        }
                        que.pop();
                        break;
                    case '[':
                        que.add(2);
                        break;
                    case ']':
                        if(que.isEmpty() || que.peek() != 2) {
                            sb.append("no\n");
                            continue loop;
                        }
                        que.pop();
                        break;
                }
            }
            if(que.isEmpty()) {
                sb.append("yes\n");
            }
            else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }

}
