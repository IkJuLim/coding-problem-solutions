class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] strs = s.split(" ");
    if (strs.length != pattern.length()) {
      return false;
    }
    Map<Character, String> mapcs = new HashMap<>();
    Map<String, Character> mapsc = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      if (mapcs.containsKey(pattern.charAt(i)) || mapsc.containsKey(strs[i])) {
        if (!mapcs.getOrDefault(pattern.charAt(i), "0").equals(strs[i]) || !mapsc.getOrDefault(strs[i], '0').equals(pattern.charAt(i))) {
          return false;
        }
      } else {
        mapcs.put(pattern.charAt(i), strs[i]);
        mapsc.put(strs[i], pattern.charAt(i));
      }
    }

    return true;
  }
}