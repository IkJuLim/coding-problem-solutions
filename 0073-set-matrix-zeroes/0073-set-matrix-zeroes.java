class Solution {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    Queue<int[]> q = new LinkedList<>();
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(matrix[i][j] == 0) {
          q.add(new int[]{i, j});
        }
      }
    }
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      for (int i = 0; i < m; i++) {
        matrix[i][curr[1]] = 0;
      }
      for (int i = 0; i < n; i++) {
        matrix[curr[0]][i] = 0;
      }
    }
  }
}