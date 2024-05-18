package dfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1060
public class DFS와BFS {
    static int N;
    static int M;
    static int V;
    static StringBuilder sb;
    static List<Integer>[] list;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());
        sb = new StringBuilder();
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        Arrays.fill(visited, false);
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        for(int i = 0; i <= N; i++)
            Collections.sort(list[i]);
        visited[V] = true;
        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        visited[V] = true;
        bfs(V);
        System.out.println(sb.toString());
    }
    public static void dfs(int idx) {
        sb.append(idx).append(" ");
        for(int i : list[idx]) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
    public static void bfs(int idx) {
        Queue<Integer> que = new LinkedList<>();
        que.add(idx);
        while(!que.isEmpty()) {
            int n = que.poll();
            sb.append(n).append(" ");
            for(int i : list[n]) {
                if(!visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
