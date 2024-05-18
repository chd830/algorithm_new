package dfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1012
public class 유기농배추 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T ; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            int cnt = 0;
            map = new int[N][M];
            for(int k = 0; k < K; k++) {
                token = new StringTokenizer(br.readLine());
                map[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = 1;
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1) {
                        cnt++;
                        Queue<Node> que = new LinkedList<>();
                        que.add(new Node(i, j));
                        map[i][j] = -1;
                        while(!que.isEmpty()) {
                            Node n = que.poll();
                            for(int d = 0; d < dir.length; d++) {
                                int dx = n.x + dir[d][0];
                                int dy = n.y + dir[d][1];
                                if(dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] == 1) {
                                    que.add(new Node(dx, dy));
                                    map[dx][dy] = -1;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
