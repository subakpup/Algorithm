import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int x = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        int l = 0, r = n-1, cnt = 0;
        
        while (l<r) {
            int cur = arr[l] + arr[r];
            if (cur < x) {
                ++l;
            } else if (cur > x) {
                --r;
            } else {
                ++cnt;
                ++l;
            }
        }
        System.out.println(cnt);
    }

}
