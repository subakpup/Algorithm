class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for (int num : num_list) {
            while (true) {
                if (num == 1) break;
                
                if (num % 2 == 0) num /= 2;
                else num = (num - 1) / 2;
                
                answer++;
            }
        }
        
        return answer;
    }
}