class Solution {
    public int solution(int n, int w, int num) {
        int h = n / w + 1;
        int[][] boxes = new int[h][w];
        
        int number = 0;
        int sr = 0; int sc = 0;
        
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    boxes[i][j] = ++number;
                    if (number == num) {
                        sr = i;
                        sc = j;
                    }
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    boxes[i][j] = ++number;
                    if (number == num) {
                        sr = i;
                        sc = j;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for (int i = sr; i < h; i++) {
            if (boxes[i][sc] <= n) answer++;
        }
        
        return answer;
    }
}