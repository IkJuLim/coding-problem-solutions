class Solution {
  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    int[] ret = new int[k];

    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    for (int[] log : logs) {
      HashSet<Integer> set = map.getOrDefault(log[0], new HashSet<>());
      set.add(log[1]);
      map.put(log[0], set);
    }
    for (int key : map.keySet()) {
      ret[map.get(key).size()-1]++;
    }

    return ret;
  }
}