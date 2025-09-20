class Solution {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int currentNumber = 0;
    int sign = 1;
    int result = 0;

    for (char c : s.toCharArray()) {
      if (c == ' ') {
        continue;
      } else if (c == '+' || c == '-') {
        result += sign * currentNumber;
        currentNumber = 0;
        sign = (c == '+') ? 1 : -1;
      } else if (c == ')') {
        result += sign * currentNumber;
        currentNumber = 0;
        result *= stack.pop();
        result += stack.pop();
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else {
        currentNumber = currentNumber * 10 + (c - '0');
      }
    }

    result += sign * currentNumber;

    return result;
  }
}