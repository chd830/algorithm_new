package bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2468
public class BOJ2468 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int maxArea = Integer.MIN_VALUE;
    static int[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        while(min <= max) {
            int[][] copy = new int[N][N];
            for(int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, copy[i], 0, N);
            }
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    // 잠기지 않는 개수
                    if(copy[i][j] >= max) {
                        cnt++;
                        Queue<Node> que = new LinkedList<>();
                        que.add(new Node(i, j));
                        copy[i][j] = 0;
                        while(!que.isEmpty()) {
                            Node n = que.poll();
                            for(int d = 0; d < dir.length; d++) {
                                int dx = n.x + dir[d][0];
                                int dy = n.y + dir[d][1];
                                if(isValid(dx, dy, copy)) {
                                    copy[dx][dy] = 0;
                                    que.add(new Node(dx, dy));
                                }
                            }
                        }
                    }
                }
            }

            maxArea = Math.max(maxArea, cnt);
            max--;
        }

        System.out.println(maxArea);
    }
    static boolean isValid(int x, int y, int[][] a) {
        return x >= 0 && y >= 0 && x < N && y < N && a[x][y] >= max;
    }
}
