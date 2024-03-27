package bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/21736
public class BOJ21736 {

    static int N;
    static int M;

    static char[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Queue<Node> que;

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
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new char[N][M];
        que = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i] = token.nextToken().toCharArray();
            for(int j = 0; j < M; j++)
                if(arr[i][j] == 'I')
                    que.add(new Node(i, j));
        }

        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && arr[dx][dy] != 'X') {
                    if(arr[dx][dy] == 'P')
                        res++;
                    que.add(new Node(dx, dy));
                    arr[dx][dy] = 'X';
                }
            }
        }
        System.out.println(res == 0 ? "TT" : res);

    }
}
