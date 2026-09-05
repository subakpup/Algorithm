import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        BigInteger answer = new BigInteger(number);
        return answer.remainder(BigInteger.valueOf(9)).intValue();
    }
}