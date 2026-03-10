class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int bulls = 0, cows = 0;
        int[] cnt = new int[26];
        for (char c : secret.toCharArray()) cnt[c - '0']++;

        for (int i = 0; i < guess.length(); i++) {
            if (cnt[guess.charAt(i) - '0'] > 0) {
                if (guess.charAt(i) == secret.charAt(i)) {
                    cnt[guess.charAt(i) - '0']--;
                    bulls++;
                } else {
                    cows++;
                    cnt[guess.charAt(i) - '0']--;
                }
            } else if (guess.charAt(i) == secret.charAt(i)){
                bulls++;
                cows--;
            }
        }
        sb.append(bulls);
        sb.append('A');
        sb.append(cows);
        sb.append('B');
        return sb.toString();
    }
}