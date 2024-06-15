package bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/7569
public class BOJ7569 {
    static class Node {
        int x;
        int y;
        int z;
        int time;
        Node(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }

    static int N;
    static int M;
    static int H;
    static int cnt;
    static int total;
    static int[][][] maps;
    static Queue<Node> que;

    static int[][] dir = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}, {0, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        maps = new int[N][M][H];
        que = new LinkedList<>();

        cnt = 0;
        total = N*M*H;
        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    maps[i][j][k] = Integer.parseInt(token.nextToken());
                    if(maps[i][j][k] == 1)
                        que.add(new Node(i, j, k, 0));
                    if(maps[i][j][k] != 0)
                        cnt++;
                }
            }
        }
        if(cnt == total)
            System.out.println(0);
        else
            System.out.println(tomato());
    }

    static void print() {
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(maps[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    static int tomato() {
        int time = 0;
        while(!que.isEmpty()) {
            if(cnt == total)
                return que.peek().time;
//            print();
            int qSize = que.size();
            for(int i = 0; i < qSize; i++) {
                Node n = que.poll();
                for (int[] d : dir) {
                    int dx = n.x + dir[d[0]][0];
                    int dy = n.y + dir[d[1]][1];

                    if (check(dx, dy, n.z)) {
                        que.add(new Node(dx, dy, n.z, n.time + 1));
                        maps[dx][dy][n.z] = 1;
                        cnt++;
                    }
                }
                for(int k = -1; k <= 1; k++) {
                    int dz = n.z+k;
                    if(check(n.x, n.y, dz)) {
                        que.add(new Node(n.x, n.y, dz, n.time + 1));
                        maps[n.x][n.y][dz] = 1;
                        cnt++;
                    }
                }
            }
            time++;
        }
        return cnt == total ? time : -1;
    }

    static boolean check(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < N && y < M && z < H && maps[x][y][z] == 0;
    }

}
