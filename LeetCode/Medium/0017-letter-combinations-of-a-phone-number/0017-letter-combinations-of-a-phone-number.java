class Solution {
  HashMap<Character, String> map = new HashMap<>();

  public List<String> letterCombinations(String digits) {
    List<String> ret = new ArrayList<>();
    if(digits == null || digits.length() == 0){
      return ret;
    }
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    ret.add("");
    for(char c : digits.toCharArray()){
      ret = combination(c, ret);
    }
    return ret;
  }
  private List<String> combination(char c, List<String> list){
    List<String> ret = new ArrayList<>();
    for(String s : list){
      for(char newC : map.get(c).toCharArray()){
        ret.add(s + newC);
      }
    }
    return ret;
  }
}