class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (c == ')') {
          if (stack.size() == 0) {
            return false;
          }
          Character top = stack.pop();
          if (!top.equals('(')) {
            return false;
          }
        }
        if (c == ']') {
          if (stack.size() == 0) {
            return false;
          }
          Character top = stack.pop();
          if (!top.equals('[')) {
            return false;
          }
        }
        if (c == '}') {
          if (stack.size() == 0) {
            return false;
          }
          Character top = stack.pop();
          if (!top.equals('{')) {
            return false;
          }
        }
      }
    }
    return (stack.size() != 0) ? false : true;
  }
}