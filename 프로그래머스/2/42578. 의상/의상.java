import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int[] vals = map.values().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < vals.length; i++) {
            answer += solve(vals, i, vals.length - i, vals[i]);
        }

        return answer;
    }

    private int solve(int[] vals, int start, int n, int val) {
        if (n == 1) {
            return val;
        }
        if (start >= vals.length) {
            return 0;
        }
        int ret = val;

        for (int i = start + 1; i < vals.length; i++) {
            ret += solve(vals, i, n - 1, vals[i] * val);
        }

        return ret;
    }
}