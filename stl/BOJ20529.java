package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/20529
public class BOJ20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] MBTI = new String[N];
            StringTokenizer token = new StringTokenizer(br.readLine());
            if(N > 32) {
                System.out.println(0);
                continue;
            }
            for(int i = 0; i < N; i++) {
                MBTI[i] = token.nextToken();
            }

            int min = Integer.MAX_VALUE;

            for(int j = 0; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    for(int l = k+1; l < N; l++) {
                        int cnt = 0;
                        for(int m = 0; m < 4; m++) {
                            cnt += MBTI[j].charAt(m) != MBTI[k].charAt(m) ? 1 : 0;
                            cnt += MBTI[j].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
                            cnt += MBTI[k].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
                        }
                        min = Math.min(cnt, min);
                        if(min == 0) break;
                    }
                }
            }
            System.out.println(min);
        }
    }
}
