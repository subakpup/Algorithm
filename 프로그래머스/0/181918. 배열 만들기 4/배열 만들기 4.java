import java.util.*;

class Solution {
    public Deque<Integer> solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0 ; i < arr.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() >= arr[i]) {
                deque.pollLast();
            }
            
            deque.offer(arr[i]);
        }
        
        return deque;
    }
}