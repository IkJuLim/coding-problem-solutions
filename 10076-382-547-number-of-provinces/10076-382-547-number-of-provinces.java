class Solution {
  boolean[] visited;
  public int findCircleNum(int[][] isConnected) {
    visited = new boolean[isConnected.length];
    int ret = 0;
    for(int i = 0; i < isConnected.length; i++){
      if(dfs(i, isConnected)){
        ret++;
      }
    }
    return ret;
  }

  public boolean dfs(int target, int[][] isConnected){
    if(visited[target]){
      return false;
    }
    visited[target] = true;
    for(int i = 0; i < isConnected.length; i++){
      if(target != i && isConnected[target][i] == 1){
        dfs(i, isConnected);
      }
    }
    return true;
  }
}