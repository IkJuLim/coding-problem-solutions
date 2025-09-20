class Solution {
  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    HashMap<String, Integer> substringMap = new HashMap<>();
    for(int idx = 0; idx < s.length(); idx++){
      for(int winSize = minSize; winSize <= maxSize; winSize++){
        if(idx + winSize <= s.length()){
          String subStr = s.substring(idx, idx + winSize);

          int lettersCnt = 0;
          LinkedList<Character> uniqueLetters = new LinkedList<>();
          for(Character c : subStr.toCharArray()){
            if(!uniqueLetters.contains(c)){
              uniqueLetters.add(c);
              lettersCnt++;
            }
          }
          if(lettersCnt > maxLetters){
            break;
          }
          if(substringMap.containsKey(subStr)) {
            substringMap.put(subStr, substringMap.get(subStr) + 1);
          }
          else{
            substringMap.put(subStr, 1);
          }
        }
      }
    }

    return substringMap.values().stream().max(Integer::compare).orElse(0);
  }
}