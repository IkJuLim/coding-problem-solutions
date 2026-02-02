class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] ret = new int[mat.length * mat[0].length];
        int len = 0;
        boolean isYIncreaseDir = true;

        for (int i = 0; i < mat.length + mat[0].length; i++) {
            int x = isYIncreaseDir ? Math.min(i, mat.length - 1) : i - Math.min(i, mat[0].length - 1);
            int y = !isYIncreaseDir ? Math.min(i, mat[0].length - 1) : i - Math.min(i, mat.length - 1);
            while ((isYIncreaseDir ? x : y) >= 0) {
                if ((x >= mat.length || y >= mat[0].length)) {
                    x = isYIncreaseDir ? x-1 : x+1;
                    y = isYIncreaseDir ? y+1 : y-1;
                    break;
                }
                ret[len] = mat[x][y];

                x = isYIncreaseDir ? x-1 : x+1;
                y = isYIncreaseDir ? y+1 : y-1;
                len++;
            }
            isYIncreaseDir = !isYIncreaseDir;
        }

        return ret;
    }
}