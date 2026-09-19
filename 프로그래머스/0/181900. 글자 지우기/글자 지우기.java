class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder();
        boolean[] idx = new boolean[my_string.length()];
        
        for (int i : indices) {
            idx[i] = true;
        }
        
        for (int i = 0 ; i < my_string.length(); i++) {
            if (idx[i]) continue;
            answer.append(my_string.charAt(i));
        }
        
        return answer.toString();
    }
}