package greedy;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10819
public class 차이를최대로 {
    static int[] arr;
    static int N;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        max = Integer.MIN_VALUE;
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        perm(new int[N], new boolean[N], 0, N);

        System.out.println(max);
    }
    public static void perm(int[] out, boolean[] visited, int d, int r) {
        if(d == r) {
            int cnt = 0;
            for(int i = 0; i < r-1; i++) {
                cnt += Math.abs(arr[out[i]]-arr[out[i+1]]);
            }
            max = Math.max(cnt, max);
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[d] = i;
                perm(out, visited, d+1, r);
                visited[i] = false;
            }
        }
    }

}
