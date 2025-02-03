class Solution {
  class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public int uniquePaths(int m, int n) {
    Queue<Pair> q = new LinkedList<>();
    int[][] cnt = new int[m + 1][n + 1];
    boolean[][] visited = new boolean[m + 1][n + 1];
    int x = m - 1, y = n - 1;
    cnt[x][y] = 1;
    q.add(new Pair(x, y));

    while (!q.isEmpty()) {
      Pair poll = q.poll();
      x = poll.a;
      y = poll.b;
      if (visited[x][y]) {
        continue;
      }
      visited[x][y] = true;
      if(x - 1 >= 0) {
        q.add(new Pair(x - 1, y));
      }
      if(y - 1 >= 0)
        q.add(new Pair(x, y-1));

      cnt[x][y] = cnt[x][y] + cnt[x + 1][y] + cnt[x][y + 1];

    }

    return cnt[0][0];
  }
}