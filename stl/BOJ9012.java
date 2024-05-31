package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9012
public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            System.out.println(check(str) ? "YES" : "NO");
        }
    }
    static boolean check(String str) {
        Stack<Integer> que = new Stack<>();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    que.add(1);
                    break;
                case ')':
                    if (!que.isEmpty())
                        que.pop();
                    else
                        return false;
                    break;
            }
        }
        return que.isEmpty();
    }

}
