package stl;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/status?user_id=chd830&problem_id=13335&from_mine=1
public class BOJ13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken()); // 다리를 건너는 트럭의 수
        int L = Integer.parseInt(token.nextToken()); // 다리의 길이
        int W = Integer.parseInt(token.nextToken()); // 최대하중
        Queue<Integer> truck = new LinkedList<>();
        token = new StringTokenizer(br.readLine());
        // 다리위에 올라갈 수 있는 트럭의 무게를 추가
        for(int i = 0; i < N; i++) {
            truck.add(Integer.parseInt(token.nextToken()));
        }

        int time = 0;
        int sum = 0;
        // 처음 오는 트럭이 지나갈 시간(다리의 길이)
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < L; i++) {
            que.add(0);
        }
        // 다리 위 공간이 빌 때까지(다 지나갈 때까지)
        while(!que.isEmpty()) {
            time++;
            sum -= que.poll(); // 첫 트럭이 빠져나감
            if(!truck.isEmpty()) {
                // 지나갈 수 있는 무게일 때
                if(truck.peek()+sum <= W) {
                    sum += truck.peek();
                    que.add(truck.poll());
                }
                // 지나갈 수 없을 때 빈 값 추가
                else {
                    que.add(0);
                }
            }
            // 트럭이 비어있다면 큐에 더이상 지나갈 수 있는 공간이 없음
        }
        System.out.println(time);
    }
}
