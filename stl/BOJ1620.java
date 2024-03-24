package stl;

import java.util.*;
import java.io.*;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> number = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            name.put(pokemon, i+1);
            number.put(i+1, pokemon);
        }
        for(int i = 0; i < M ; i++) {
            String value = br.readLine();
            if(Character.isAlphabetic(value.charAt(0))) {
                System.out.println(name.get(value));
            }
            else {
                System.out.println(number.get(Integer.parseInt(value)));
            }
        }
    }
}
