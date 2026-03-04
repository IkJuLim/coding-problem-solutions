class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, ++cnt);
        }

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, (a, b) -> a - b);

        int idx = 0;

        while (values.get(idx) <= k) {
            k -= values.get(idx);
            idx++;
            if (idx == values.size()) break;
        }

        return values.size() - idx;
    }
}