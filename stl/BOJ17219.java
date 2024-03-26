package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17219
public class BOJ17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            map.put(token.nextToken(), token.nextToken());
        }
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            sb.append(map.get(str)).append("\n");
        }
        System.out.println(sb);
    }
}
