class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    ArrayList<Integer> list = new ArrayList<>();
    List<Integer> keys = new ArrayList<>(map.keySet());
    keys.sort(Integer::compare);

    for (int num : keys) {
      int val = map.get(num) > 3 ? 3 : map.get(num);
      for (; val > 0; val--) {
        list.add(num);
      }
    }



    HashSet<List<Integer>> ret = new HashSet<>();
    for (int i = 1; i < list.size() - 1; i++) {
      int l = 0, r = list.size() - 1;
      while (l < i && r > i) {
        int sum = list.get(l) + list.get(i) + list.get(r);
        if (sum == 0) {
          ret.add(Arrays.asList(list.get(l), list.get(i), list.get(r)));
          r--;
          l++;
        } else if (sum > 0) {
          r--;
        } else {
          l++;
        }
      }

    }

    return new ArrayList<>(ret);
  }
}