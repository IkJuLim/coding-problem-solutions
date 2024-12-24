class Solution {
  public static boolean[] v;
    
  public static boolean canReach(int[] arr, int start) {
    int len = arr.length;
    v = new boolean[len];
    return dfs(arr, start);
  }

  public static boolean dfs(int[] arr, int start) {
    if (start < 0 || start >= arr.length || v[start]) {
      return false;
    }
    if (arr[start] == 0) {
      return true;
    }
    v[start] = true;
    return dfs(arr, start + arr[start]) || dfs(arr, start - arr[start]);
  }
}