class Solution {
  public int romanToInt(String s) {
    char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int len = s.length();
    int ret = 0;
    int tmp = 0;
    tmp += map.get(s.charAt(0));
    for (int i = 1; i < len; i++) {
      char c = s.charAt(i);
      if (map.get(c) < map.get(s.charAt(i - 1))) {
        ret += tmp;
        tmp = 0;
      }
      if (map.get(c) > map.get(s.charAt(i - 1))) {
        ret += map.get(c) - tmp;
        tmp = 0;
        continue;
      }
      tmp += map.get(c);
    }
    ret += tmp;
    return ret;
  }
}