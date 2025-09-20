class Solution {
  boolean[] visited;
  int len;
  public int findCircleNum(int[][] isConnected) {
    len = isConnected.length;
    visited = new boolean[len];
    int ret = 0;
    for(int i = 0; i < len; i++){
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
    for(int i = 0; i < len; i++){
      if(target != i && isConnected[target][i] == 1){
        dfs(i, isConnected);
      }
    }
    return true;
  }
}