import java.util.Stack;

class Solution {
  public String simplifyPath(String path) {
    String ret = new String();
    Stack<String> stack = new Stack<>();

    for (String folder : path.split("/")) {
      if (folder.equals(".")) {
        continue;
      } else if (folder.equals("..")) {
        if (!stack.empty()) {
          stack.pop();
        }
      } else if (folder.equals("")) {
        continue;
      } else {
        stack.push(folder);
      }
    }
    while (!stack.empty()) {
      ret = "/" + stack.pop() + ret;
    }
    if (ret.length() == 0) {
      return "/";
    }
    return ret;
  }
}