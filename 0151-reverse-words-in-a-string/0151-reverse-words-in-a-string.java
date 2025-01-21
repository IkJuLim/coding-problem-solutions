class Solution {
  public String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      if (words[i].length() != 0) {
        sb.append(words[i] + " ");
      }
    }
    sb.delete(sb.length() - 1, sb.length());
    return sb.toString();
  }
}
