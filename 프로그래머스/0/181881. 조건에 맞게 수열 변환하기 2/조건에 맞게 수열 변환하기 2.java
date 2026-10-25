import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int answer = -1;
        
        while (true) {
            answer++;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) arr2[i] /= 2;
                else if (arr[i] < 50 && arr[i] % 2 == 1) arr2[i] = arr2[i] * 2 + 1;
                else arr2[i] = arr[i];
            }
            
            if (Arrays.equals(arr, arr2)) {
                break;
            }
            
            arr = Arrays.copyOf(arr2, arr2.length);
        }
        
        return answer;
    }
}