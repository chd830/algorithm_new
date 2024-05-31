package recur;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/15650
public class BOJ15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[M];
        sb = new StringBuilder();
        perm(1, 0);
        System.out.println(sb);
    }
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;
    static void perm(int x, int y) {
        if(y == M) {
            for(int i = 0 ;i < M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = x; i <= N; i++) {
            arr[y] = i;
            perm(i+1, y+1);
        }
    }
}
