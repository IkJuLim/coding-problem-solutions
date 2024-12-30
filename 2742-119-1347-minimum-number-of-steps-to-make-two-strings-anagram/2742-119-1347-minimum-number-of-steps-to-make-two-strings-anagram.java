class Solution {
  public int minSteps(String s, String t) {
    int ret = 0;
    int[] sArray = new int[26];
    int[] tArray = new int[26];
    for(int i = 0; i < s.length(); i++){
      int cs = s.charAt(i) - 'a';
      int ct = t.charAt(i) - 'a';
      sArray[cs]++;
      tArray[ct]++;
    }
    for(int i = 'a' - 'a'; i <= 'z' - 'a'; i++){
      if(sArray[i] > tArray[i]){
        ret += sArray[i] - tArray[i];
      }
      else{
        ret += tArray[i] - sArray[i];
      }
    }

    return ret/2;
  }
}