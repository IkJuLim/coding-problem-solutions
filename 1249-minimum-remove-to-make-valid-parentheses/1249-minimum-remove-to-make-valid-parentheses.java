class Solution {
    public String minRemoveToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();
    int cnt = 0;
    for(int idx = 0; idx < s.length(); idx++){
      if(s.charAt(idx) != ')') {
        if(s.charAt(idx) == '('){
          cnt++;
        }
        stack.push(s.charAt(idx));
      }
      else if(s.charAt(idx) == ')' && cnt > 0){
        stack.push(s.charAt(idx));
        cnt--;
      }
    }
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()){
      if(cnt > 0 && stack.peek() == '('){
        stack.pop();
        cnt--;
      }
      else{
        sb.append(stack.pop());
      }
    }
    return sb.reverse().toString();
        
    }
}