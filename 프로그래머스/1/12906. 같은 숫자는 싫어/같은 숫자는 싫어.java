import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> ret = new ArrayList<>();
        ret.add(arr[0]);
        int curr = arr[0];

        for (int i : arr) {
            if (curr == i) {
                continue;
            }
            ret.add(i);
            curr = i;
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}