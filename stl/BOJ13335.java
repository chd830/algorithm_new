package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/status?user_id=chd830&problem_id=13335&from_mine=1
public class BOJ13335 {
    static class Node {
        int val;
        int idx;
        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken()); // 다리를 건너는 트럭의 수
        int L = Integer.parseInt(token.nextToken()); // 다리의 길이
        int W = Integer.parseInt(token.nextToken()); // 최대하중
        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Queue<Node> que = new LinkedList<>();
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < N;) {
            if(sum+arr[i] <= W) {
                que.add(new Node(L, i));
                sum += arr[i++];
            }

            int size = que.size();
            cnt++;
            for(int j = 0; j < size; j++) {

                if(que.isEmpty())
                    break;
                Node n = que.poll();
                if (n.val > 0) {
                    que.add(new Node(n.val - 1, n.idx));
                } else {
                    sum -= arr[n.idx];
                }
            }
            if(que.isEmpty())
                continue;
            Node tmp = que.peek();
            if(tmp.val == 0) {
                que.poll();
                sum -= arr[tmp.idx];
            }
        }
        while(!que.isEmpty()) {
            int size = que.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                if(que.isEmpty())
                    break;
                Node n = que.poll();
                if(n.val > 0) {
                    flag = true;
                    que.add(new Node(n.val-1, n.idx));
                }
            }
            if(flag)
                cnt++;
        }

        System.out.println(cnt+1);
    }
}
