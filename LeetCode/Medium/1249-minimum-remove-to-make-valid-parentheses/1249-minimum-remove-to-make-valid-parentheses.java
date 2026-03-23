class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openCnt = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCnt++;
            }
            else if (c == ')') {
                if (openCnt <= 0) {
                    continue;
                }
                openCnt--;
            }
            stack.add(c);
        }
        while (!stack.empty()) {
            char c = stack.pop();
            if (openCnt > 0 && c == '(') {
                openCnt--;
                continue;
            }
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}