class Solution {
    public int canBeTypedWords(String text, String brokenLetters){ 
        Set<Character> set = new HashSet<>();
        int cnt = 0;
        String arr[] = text.split("\\s");

        for(char ch : brokenLetters.toCharArray())   set.add(ch);

        for(String str : arr){
            for(char ch : str.toCharArray()){
                if(set.contains(ch)){
                    cnt++;
                    break;
                }
            }
        }

        return arr.length - cnt;
    }
}