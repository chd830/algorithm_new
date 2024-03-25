package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2630
public class BOJ2630 {
    static int N;
    static int[] cnt = new int[2];
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                Arrays.fill(visited[i], false);
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        recur(0, 0, N);

        System.out.println(cnt[0]+"\n"+cnt[1]);
    }

    static boolean check(int x, int y, int size) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[x][y] != arr[i][j])
                    return false;
            }
        }
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                visited[i][j] = true;
            }
        }
        return true;
    }

    public static void recur(int x, int y, int size) {
        if(size < 1)
            return;
        for(int i = x; i < N; i+=size) {
            for(int j = y; j < N; j+=size) {
                if(!visited[i][j] && check(i, j, size)) {
                    cnt[arr[i][j]]++;
                }
            }
        }
        recur(x, y, size/2);
    }

}

