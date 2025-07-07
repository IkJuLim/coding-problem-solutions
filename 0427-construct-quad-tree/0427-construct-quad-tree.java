class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length, grid[grid.length-1].length);
    }

    public Node construct(int[][] grid, int topLeft_x, int topLeft_y, int bottomRight_x, int bottomRight_y) {

        boolean isLeaf = true;
        Node node = new Node(grid[topLeft_x][topLeft_y] == 1, isLeaf);

        if (bottomRight_x - topLeft_x == 1) {
            return node;
        }

        for (int i = topLeft_x; i < bottomRight_x; i++) {
            for (int j = topLeft_y; j < bottomRight_y; j++) {
                if (grid[topLeft_x][topLeft_y] != grid[i][j]) {
                    isLeaf = false;
                }
            }
        }

        if (!isLeaf) {
            node.isLeaf = isLeaf;
            node.topLeft = construct(grid,
                            topLeft_x,
                            topLeft_y,
                            (topLeft_x + bottomRight_x) / 2,
                            (topLeft_y + bottomRight_y) / 2);
            node.topRight = construct(grid,
                            topLeft_x,
                            (topLeft_y + bottomRight_y) / 2,
                            (topLeft_x + bottomRight_x) / 2,
                            bottomRight_y);
            node.bottomLeft = construct(grid,
                            (topLeft_x + bottomRight_x) / 2,
                            topLeft_y,
                            bottomRight_x,
                            (topLeft_y + bottomRight_y) / 2);
            node.bottomRight = construct(grid,
                            (topLeft_x + bottomRight_x) / 2,
                            (topLeft_y + bottomRight_y) / 2,
                            bottomRight_x,
                            bottomRight_y);
        }

        return node;
    }
}