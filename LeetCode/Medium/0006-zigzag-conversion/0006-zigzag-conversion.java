class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int len = s.length();
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < numRows; row++) {
      int idx = row;
      while (idx < len) {
        sb.append(s.charAt(idx));
        if (!(row == 0 || row == numRows - 1) && idx + 2 * numRows - 2 * row - 2 < len) {
          sb.append(s.charAt(idx + 2 * numRows - 2 * row - 2));
        }
        idx += 2 * numRows - 2;
      }
    }
    return sb.toString();
  }
}