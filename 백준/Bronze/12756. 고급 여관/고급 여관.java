import java.util.*;
import java.io.*;

class Main {
    
    static int power1, power2, hp1, hp2;

    private static void solve() {
        while (hp1 > 0 && hp2 > 0) {
            hp1 -= power2;
            hp2 -= power1;

            if (hp1 < 1 && hp2 < 1) {
                System.out.println("DRAW");
            } else if (hp2 < 1) {
                System.out.println("PLAYER A");
            } else if (hp1 < 1) {
                System.out.println("PLAYER B");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        power1 = Integer.parseInt(st.nextToken());
        hp1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        power2 = Integer.parseInt(st.nextToken());
        hp2 = Integer.parseInt(st.nextToken());

        solve();
    }
}