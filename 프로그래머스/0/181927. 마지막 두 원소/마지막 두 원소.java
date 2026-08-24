import java.util.*;
import java.util.stream.*;

class Solution {
    public List solution(int[] num_list) {      
        List<Integer> answer = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        
        int n = num_list.length;
        int last = num_list[n - 1];
        int lastb = num_list[n - 2];
        
        answer.add(last > lastb ? last - lastb : last * 2);

        return answer;
    }
}