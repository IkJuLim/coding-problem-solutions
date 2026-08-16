import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ret = new ArrayList<>();
        int days = 0;

        int i = 0;
        while (i < progresses.length) {
            while ((progresses[i] + speeds[i] * days) < 100) {
                days++;
            }
            i++;
            int cnt = 1;

            while (i < progresses.length && (progresses[i] + speeds[i] * days) >= 100) {
                cnt++;
                i++;
            }
            ret.add(cnt);
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}