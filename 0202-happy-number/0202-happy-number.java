class Solution {
  public boolean isHappy(int n) {
    HashSet<Integer> visited = new HashSet<>();
    int tmp = n;
    while (!visited.contains(tmp)) {
      if (tmp == 1) {
        return true;
      }
      visited.add(tmp);
      int current = 0;
      while (tmp != 0) {
        current += (tmp % 10) * (tmp % 10);
        tmp /= 10;
      }
      tmp = current;
    }
    return false;
  }
}