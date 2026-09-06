class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();
        
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            
            while (start < end) {
                char tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                
                start++;
                end--;
            }
        }
        
        String answer = new String(arr);
        
        return answer;
    }
}