class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] cnt = new int[27];
    for (char c : ransomNote.toCharArray()) {
      cnt[c - 'a']++;
    }
    for (char c : magazine.toCharArray()) {
      cnt[c - 'a']--;
    }
    for (int i : cnt) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }
}