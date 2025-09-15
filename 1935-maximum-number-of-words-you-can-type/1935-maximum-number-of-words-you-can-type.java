class Solution {
    public int canBeTypedWords(String text, String brokenLetters){ 
        List<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
        if (!brokenLetters.equals("")) {
            for (String brokenLetter : brokenLetters.split("")) {
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).contains(brokenLetter)) {
                        words.remove(words.get(i));
                        i--;
                    }
                }
            }
        }
        return words.size();
    }
}