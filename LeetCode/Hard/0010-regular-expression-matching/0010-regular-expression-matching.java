class Solution {
    public boolean isMatch(String s, String p) {
        boolean isPossible = false;
        if (s.length() > 0 && p.length() == 0) return false;
        else if (s.length() == 0 && p.length() == 0) return true;

        if (p.length() > 1) {
            if (p.charAt(1) == '*') {
                if (p.charAt(0) == '.') {
                    isPossible |= isMatch(s, p.substring(2));
                    if (s.length() == 0) isPossible |= false;
                    else isPossible |= isMatch(s.substring(1), p);
                }
                else {
                    isPossible |= isMatch(s, p.substring(2));
                    if (s.length() == 0) isPossible |= false;
                    else if (p.charAt(0) == s.charAt(0)) isPossible |= isMatch(s.substring(1), p);
                }
            }
            else {
                if (s.length() == 0) isPossible |= false;
                else if (p.charAt(0) == '.') isPossible |= isMatch(s.substring(1), p.substring(1));
                else if (p.charAt(0) == s.charAt(0)) isPossible |= isMatch(s.substring(1), p.substring(1));
                else isPossible |= false;
            }
        }
        else {
            if (s.length() == 0) isPossible |= false;
            else if (p.charAt(0) == '.') isPossible |= isMatch(s.substring(1), p.substring(1));
            else if (s.charAt(0) == p.charAt(0)) isPossible |= isMatch(s.substring(1), p.substring(1));
        }
        return isPossible;
    }
}