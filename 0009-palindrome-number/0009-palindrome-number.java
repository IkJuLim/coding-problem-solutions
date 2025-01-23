class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    return isPalindrome(Integer.toString(x));
  }

  public boolean isPalindrome(String x) {
    if (x.length() == 1) {
      return true;
    }
    if (x.length() == 2) {
      if (x.charAt(0) == x.charAt(1)) {
        return true;
      }
      return false;
    }

    if (x.charAt(0) == x.charAt(x.length() - 1)) {
      return isPalindrome(x.substring(1, x.length() - 1));
    }
    return false;
  }
}