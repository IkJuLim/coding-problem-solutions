class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    char[][] map;
    boolean[][] visited;
    int m, n;
    public int numIslands(char[][] grid) {
        int ret = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        this.map = grid;
        this.visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    ret++;
                    findIsland(i, j);
                }
            }
        }

        return ret;
    }

    private void findIsland(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && map[nextX][nextY] == '1') {
                findIsland(nextX, nextY);
            }
        }
    }
}