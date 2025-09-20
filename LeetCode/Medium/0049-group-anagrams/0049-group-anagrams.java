class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> ret = new ArrayList<>();

    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedStr = String.valueOf(charArray);

      List<String> strList = map.getOrDefault(sortedStr, new ArrayList<>());
      strList.add(str);
      map.put(sortedStr, strList);
    }

    for (List<String> l : map.values()) {
      ret.add(l);
    }
    return ret;
  }
}