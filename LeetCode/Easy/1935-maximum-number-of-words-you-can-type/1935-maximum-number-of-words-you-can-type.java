class Solution {
    public int canBeTypedWords(String text, String brokenLetters){
        List<String> words = new LinkedList<>(Arrays.asList(text.split(" ")));
        if (!brokenLetters.equals("")) {
            for (int i = 0; i < words.size(); i++) {
                for (String brokenLetter : brokenLetters.split("")) {
                    if (words.get(i).contains(brokenLetter)) {
                        words.remove(words.get(i));
                        i--;
                        break;
                    }
                }
            }
        }
        return words.size();
    }
}