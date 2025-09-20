class WordDictionary {
  List<String> words;

  public WordDictionary() {
    words = new LinkedList<>();
  }

  public void addWord(String word) {
    words.add(word);
  }

  public boolean search(String word) {
    for (String s : words) {
      if (word.length() == s.length()) {
        for (int i = 0; i < word.length(); i++) {
          if (word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) {
            break;
          } else if (i == word.length() - 1) {
            return true;
          }
        }
      }
    }
    return false;
  }
}