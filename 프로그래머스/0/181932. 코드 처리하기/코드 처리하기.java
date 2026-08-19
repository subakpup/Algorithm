class Solution {
    public String solution(String code) {
        boolean mode = false;
        String ret = "";
        
        for (int idx = 0; idx < code.length(); idx++) {
            if (code.charAt(idx) == '1') {
                mode = !mode;
                continue;
            }
            
            if (mode) {
                if (idx % 2 == 0) continue;
                ret += code.charAt(idx);
            } else {
                if (idx % 2 == 1) continue;
                ret += code.charAt(idx);
            }
        }
        
        return ret.isEmpty() ? "EMPTY" : ret;
    }
}