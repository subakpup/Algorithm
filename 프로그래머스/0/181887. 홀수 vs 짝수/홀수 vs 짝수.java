class Solution {
    public int solution(int[] num_list) {
        int n1 = 0, n2 = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 1) n1 += num_list[i];
            else n2 += num_list[i];
        }
        
        return n1 > n2 ? n1 : n2;
    }
}