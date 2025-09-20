class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    int ret = 0;
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        while (sb.charAt(0) != c) {
          set.remove(sb.charAt(0));
          sb.delete(0, 1);
        }
        set.remove(sb.charAt(0));
        sb.delete(0, 1);
      }
      set.add(c);
      sb.append(c);
      ret = Math.max(ret, sb.length());
    }
    return ret;
  }
}