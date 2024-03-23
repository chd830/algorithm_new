package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10816
public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        StringTokenizer token = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        while(token.hasMoreTokens()) {
            int n = Integer.parseInt(token.nextToken());
            if(map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            }
            else {
                map.put(n, 1);
            }
        }
        br.readLine();
        token = new StringTokenizer(br.readLine());
        while(token.hasMoreTokens()) {
            int n = Integer.parseInt(token.nextToken());
            if (map.containsKey(n))
                sb.append(map.get(n)).append(" ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}
