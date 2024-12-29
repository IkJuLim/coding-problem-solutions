class Solution {
  List<Integer> nodes = new LinkedList<>();
  public int findCircleNum(int[][] isConnected) {
    int ret = 0;
    for(int i = 0; i < isConnected.length; i++){
      nodes.add(i);
    }
    while (!nodes.isEmpty()){
      for(int i = 0; i < isConnected.length; i++){
        if(dfs(i, isConnected)){
          ret++;
        }
      }
    }
    return ret;
  }

  public boolean dfs(Integer target, int[][] isConnected){
    if(!nodes.contains(target)){
      return false;
    }
    nodes.remove(target);
    for(int i = 0; i < isConnected.length; i++){
      if(target != i && isConnected[target][i] == 1){
        dfs(i, isConnected);
      }
    }
    return true;
  }
}