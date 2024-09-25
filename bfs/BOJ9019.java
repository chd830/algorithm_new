package bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9019
public class BOJ9019 {
    static class Node {
        String n;
        String str;
        Node(String n, String str) {
            this.n = n;
            this.str = str;
        }
    }
    static boolean[] nums = new boolean[10000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        loop: for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String before = token.nextToken();
            String after = token.nextToken();
            Arrays.fill(nums, false);
            nums[Integer.parseInt(before)] = true;
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(before, ""));
            while(!que.isEmpty()) {
                Node q = que.poll();
                if(Integer.parseInt(after) == Integer.parseInt(q.n)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(q.str);
                    System.out.println(sb.reverse());
                    continue loop;
                }
                int n = Integer.parseInt(q.n);
                // D
                if(n*2 < nums.length && !nums[n*2]) {
                    que.add(new Node(String.valueOf(n*2), q.str+"D"));
                    nums[n*2] = true;
                }
                // S
                if(n == 0 && !nums[9999]) {
                    que.add(new Node(String.valueOf(9999), q.str+"S"));
                    nums[9999] = true;
                }
                if(n-1 >= 0 && !nums[n-1]) {
                    que.add(new Node(String.valueOf(n-1), q.str+"S"));
                    nums[n-1] = true;
                }
                // L
                String left = q.n.substring(1, q.n.length())+q.n.charAt(0);
                int l = Integer.parseInt(left);
                if(!nums[l]) {
                    que.add(new Node(left, q.str+"L"));
                    nums[l] = true;
                }
                // R
                String right = q.n.charAt(q.n.length()-1)+q.n.substring(0, q.n.length()-1);
                int r = Integer.parseInt(right);
                if(!nums[r]) {
                    que.add(new Node(right, q.str+"R"));
                    nums[r] = true;
                }
            }
        }
    }
}
