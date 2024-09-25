package bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2667
public class BOJ2667 {
    static int N;
    static int house;
    static int[][] arr;
    static List<Integer> list = new ArrayList<>();
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

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    house++;
                    int cnt = 0;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    arr[i][j] = 0;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        cnt++;
                        for(int d = 0; d < dir.length; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(isValidate(dx, dy)) {
                                arr[dx][dy] = 0;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(house).append("\n");
        list.stream().forEach(x -> sb.append(x).append("\n"));
        System.out.println(sb);

    }

    static boolean isValidate(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && arr[x][y] == 1;
    }
}
