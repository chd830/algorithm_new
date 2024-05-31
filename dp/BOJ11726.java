package dp;

import java.io.*;

// https://www.acmicpc.net/problem/11726
public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        d[1] = 1;
        if(N >= 2)
            d[2] = 2;
        for(int i = 3; i <= N; i++) {
            d[i] = (d[i-1]%10007+d[i-2]+10007)%10007;
        }
        System.out.println(d[N]);
    }
}
