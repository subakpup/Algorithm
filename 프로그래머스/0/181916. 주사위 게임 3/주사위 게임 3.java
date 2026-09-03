class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        if (a == b && b == c && c == d) answer = 1111 * a;
        else if (a == b && b == c) answer = (int) Math.pow(10 * b + d, 2);
        else if (b == c && c == d) answer = (int) Math.pow(10 * c + a, 2);
        else if (c == d && d == a) answer = (int) Math.pow(10 * d + b, 2);
        else if (a == b && b == d) answer = (int) Math.pow(10 * b + c, 2);
        else if (a == b && c == d) answer = (a + c) * Math.abs(a - c);
        else if (a == c && b == d) answer = (a + b) * Math.abs(a - b);
        else if (a == d && b == c) answer = (a + c) * Math.abs(a - c);
        else if (a == b) answer = c * d;
        else if (a == c) answer = b * d;
        else if (a == d) answer = b * c;
        else if (b == c) answer = a * d;
        else if (b == d) answer = a * c;
        else if (c == d) answer = a * b;
        else answer = Math.min(a, Math.min(b, Math.min(c, d)));
        
        return answer;
    }
}