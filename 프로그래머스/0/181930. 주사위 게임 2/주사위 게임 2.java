class Solution {
    public int solution(int a, int b, int c) {
        int r1 = a + b + c;
        int r2 = a*a + b*b + c*c;
        int r3 = a*a*a + b*b*b + c*c*c;
        
        if (a == b && b == c) return r1 * r2 * r3;
        else if (a == b || b == c || c == a) return r1 * r2;
        else return r1;
    }
}