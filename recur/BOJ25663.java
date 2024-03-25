package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15663
public class BOJ25663 {
    static int N;
    static int M;
    static int[] arr;
    static int[] res;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        res = new int[M];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        recur(0);
    }
    static void recur(int cnt) {
        if(cnt == M) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < M; i++) {
                str.append(res[i]).append(" ");
            }
            if(set.add(str.toString())) {
                System.out.println(str);
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[cnt] = arr[i];
                recur(cnt+1);
                visited[i] = false;
            }
        }
    }
}
