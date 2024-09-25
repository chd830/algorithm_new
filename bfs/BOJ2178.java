package bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2178
public class BOJ2178 {

    static class Node {
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    static int N;
    static int M;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, arr[0][0]));
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                System.out.println(n.val);
                break;
            }
            for(int d = 0; d < dir.length; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isValidate(dx, dy)) {
                    arr[dx][dy] = -1;
                    que.add(new Node(dx, dy, n.val+1));
                }
            }
        }
    }
    static boolean isValidate(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && arr[x][y] == 1;
    }
}
