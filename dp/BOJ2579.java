package dp;

import java.io.*;

// https://www.acmicpc.net/problem/2579
public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        d[1] = arr[1];
        if(N >= 2)
            d[2] = arr[1]+arr[2];
        for(int i = 3; i <= N; i++) {
            d[i] = Math.max(d[i-2]+arr[i], d[i-3]+arr[i-1]+arr[i]);
        }
        System.out.println(d[N]);
    }
}
