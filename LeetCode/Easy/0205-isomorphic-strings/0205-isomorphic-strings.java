class Solution {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if ((map.containsKey(s.charAt(i)))) {
        if (map.get(s.charAt(i)) != t.charAt(i)) {
          return false;
        }
      } else {
        map.put(s.charAt(i), t.charAt(i));
      }
    }
    HashSet<Character> values = new HashSet<>(map.values());
    HashSet<Character> keys = new HashSet<>(map.keySet());
    if (values.size() != keys.size()) {
      return false;
    }
    return true;
  }
}