package greedy;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17626
public class BOJ17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 1;
        int min = 0;
        for(int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++) {
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min+1;
        }
        System.out.println(dp[N]);
   }
}
