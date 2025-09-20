class Solution {
  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) {
      return true;
    }
    int sStart = 0, sEnd = s.length() - 1;
    int tStart = 0, tEnd = t.length() - 1;
    while (tStart <= tEnd) {
      if (sStart == s.length() || sEnd == -1) {
        return true;
      }
      if (s.charAt(sStart) == t.charAt(tStart)) {
        sStart++;
        tStart++;
        continue;
      }
      if (s.charAt(sEnd) == t.charAt(tEnd)) {
        sEnd--;
        tEnd--;
        continue;
      }
      tEnd--;
      tStart++;
    }
    if (sStart > sEnd) {
      return true;
    }
    return false;
  }
}