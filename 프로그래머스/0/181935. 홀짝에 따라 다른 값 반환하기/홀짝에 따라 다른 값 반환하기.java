class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = (n % 2 == 1 ? 1 : 2); i <= n; i += 2) {
            answer += (n % 2 == 1 ? i : i * i);
        }
        
        return answer;
    }
}