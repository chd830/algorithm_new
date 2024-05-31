package recur;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15649
public class BOJ15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        sb = new StringBuilder();
        perm(1, 0);
        System.out.println(sb);
    }
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static void perm(int x, int y) {
        if(y == M) {
            for(int i = 0 ;i < M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[y] = i;
                perm(i+1, y+1);
                visited[i] = false;
            }

        }
    }
}
