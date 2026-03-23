class Solution {
    public int minSteps(String s, String t) {
        int[] cntS = new int[26], cntT = new int[26];
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            cntS[s.charAt(i) - 'a']++;
            cntT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            ret += Math.abs(cntS[i] - cntT[i]);
        }
        return ret / 2;
    }
}