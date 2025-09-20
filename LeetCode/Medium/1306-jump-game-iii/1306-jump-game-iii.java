class Solution {
  public Set<Integer> visited = new HashSet<>();
  public boolean canReach(int[] arr, int start) {
    if(start >= arr.length || start < 0 || visited.contains(start)){
      return false;
    }
    if(arr[start] == 0){
      return true;
    }
    visited.add(start);
    return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
  }
}