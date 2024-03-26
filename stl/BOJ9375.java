package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9375
public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            List<List<String>> list = new ArrayList<>();
            for(int j = 0 ;j < M; j++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                String wear = token.nextToken();
                String kind = token.nextToken();
                if(map.containsKey(kind)) {
                    List<String> subLst = list.get(map.get(kind)-1);
                    subLst.add(kind);
                    list.set(map.get(kind)-1, subLst);
                }
                else {
                    List<String> subLst = new ArrayList<>();
                    subLst.add(wear);
                    list.add(subLst);
                    map.put(kind, list.size());
                }
            }
            if(list.size() == 1) {
                sb.append(M).append("\n");
            }
            else {
                int cnt = 1;
                for(List<String> l : list) {
                    cnt *= l.size()+1;
                }
                sb.append(cnt-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
