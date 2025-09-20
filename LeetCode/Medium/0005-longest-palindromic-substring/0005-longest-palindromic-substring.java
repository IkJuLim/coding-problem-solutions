class Solution {
  public String longestPalindrome(String s) {
    StringBuilder sb;
    String ret = "";
    for (int i = 0; i < s.length(); i++) {
      sb = new StringBuilder();
      for (int j = i; j < s.length(); j++) {
        sb.append(s.charAt(j));
        if (ret.length() < sb.length() && isPalindrome(sb)) {
          ret = sb.toString();
        }
      }
    }
    return ret;
  }
  private boolean isPalindrome(StringBuilder sb) {
    int len = sb.length();
    for (int i = 0; i < len/2; i++) {
      if (sb.charAt(i) != sb.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }
}