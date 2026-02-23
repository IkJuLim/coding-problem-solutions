class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++)
            if (!isOrdered(words[i], words[i + 1], order))
                return false;
        return true;
    }

    private boolean isOrdered(String word1, String word2, String order) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            order.indexOf(word1.substring(i, i));
            if (order.indexOf(word1.substring(i, i+1)) > order.indexOf(word2.substring(i, i+1)))
                return false;
            else if (order.indexOf(word1.substring(i, i+1)) < order.indexOf(word2.substring(i, i+1)))
                return true;
        }
        if(word1.length() > word2.length()) return false;
        return true;
    }
}