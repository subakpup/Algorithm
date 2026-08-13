class Solution {
    public int solution(int a, int b) {
        int A = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int B = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
        
        return A > B ? A : B;
    }
}