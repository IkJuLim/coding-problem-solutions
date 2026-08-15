//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//    public int solution(String[][] clothes) {
//        int answer = 0;
//
//        Map<String, Integer> map = new HashMap<>();
//        for (String[] clothe : clothes) {
//            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
//        }
//
//        int[] vals = map.values().stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
//
//        for (int i = 0; i < vals.length; i++) {
//            answer += solve(vals, i, vals.length - i, vals[i]);
//        }
//
//        return answer;
//    }
//
//    private int solve(int[] vals, int start, int n, int val) {
//        if (n == 1) {
//            return val;
//        }
//        if (start >= vals.length) {
//            return 0;
//        }
//        int ret = val;
//
//        for (int i = start + 1; i < vals.length; i++) {
//            ret += solve(vals, i, n - 1, vals[i] * val);
//        }
//
//        return ret;
//    }
//}


import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ret = new ArrayList<>();
        HashMap<String, PriorityQueue<int[]>> maps = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            PriorityQueue<int[]> pq = maps.getOrDefault(genres[i], new PriorityQueue<>((a, b) -> b[1] - a[1]));
            pq.add(new int[]{i, plays[i]});
            maps.put(genres[i], pq);
        }
        List<Map.Entry<String, Integer>> genrePlays = new ArrayList<>(map.entrySet());
        genrePlays.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> genrePlay : genrePlays) {
            PriorityQueue<int[]> pq = maps.get(genrePlay.getKey());
            ret.add(pq.poll()[0]);
            if (!pq.isEmpty()) {
                ret.add(pq.poll()[0]);
            }
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}