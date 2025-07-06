class Solution {
    public Node construct(int[][] grid) {
        Node node = construct(grid, 0, 0, grid.length, grid[grid.length-1].length);
        return node;
    }

    public Node construct(int[][] grid, int topLeft_x, int topLeft_y, int bottomRight_x, int bottomRight_y) {
        if (bottomRight_x - topLeft_x == 1) {
            return new Node(grid[topLeft_x][topLeft_y] == 1, true);
        }
        boolean isLeaf = true;
        for (int i = topLeft_x; i < bottomRight_x; i++) {
            for (int j = topLeft_y; j < bottomRight_y; j++) {
                if (grid[topLeft_x][topLeft_y] != grid[i][j]) {
                    isLeaf = false;
                }
            }
        }

        Node node;

        if (!isLeaf) {
            node = new Node(grid[topLeft_x][topLeft_y] == 1, isLeaf,
                    construct(grid,
                            topLeft_x,
                            topLeft_y,
                            (topLeft_x + bottomRight_x) / 2,
                            (topLeft_y + bottomRight_y) / 2),
                    construct(grid,
                            topLeft_x,
                            (topLeft_y + bottomRight_y) / 2,
                            (topLeft_x + bottomRight_x) / 2,
                            bottomRight_y),
                    construct(grid,
                            (topLeft_x + bottomRight_x) / 2,
                            topLeft_y,
                            bottomRight_x,
                            (topLeft_y + bottomRight_y) / 2),
                    construct(grid,
                            (topLeft_x + bottomRight_x) / 2,
                            (topLeft_y + bottomRight_y) / 2,
                            bottomRight_x,
                            bottomRight_y)
            );
        } else {
            node = new Node(grid[topLeft_x][topLeft_y] == 1, isLeaf);
        }

        return node;
    }
}