class Solution {
  public int strStr(String haystack, String needle) {
    if (haystack.length() == 0 || needle.length() == 0 || haystack.length() < needle.length()) {
      return -1;
    }
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      boolean b = true;
      for (int j = 0; j < needle.length(); j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          b = false;
          break;
        }
      }
      if (b) {
        return i;
      }
    }
    return -1;
  }
}