class Solution {
    public int solution(int[] num_list) {
        int r1 = 1;
        int r2 = 0;
        
        for (int num : num_list) {
            r1 *= num;
            r2 += num;
        }
        
        r2 *= r2;
        
        return r1 < r2 ? 1 : 0;
    }
}