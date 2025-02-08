class Solution {
  public String longestCommonPrefix(String[] strs) {
    int minL = 201;
    for (String s : strs) {
      if (s.length() < minL) {
        minL = s.length();
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < minL; i++) {
      char c = strs[0].charAt(i);
      for (String s : strs) {
        if (s.charAt(i) != c) {
          return sb.toString();
        }
      }
    sb.append(c);
    }
    return sb.toString();
  }
}
