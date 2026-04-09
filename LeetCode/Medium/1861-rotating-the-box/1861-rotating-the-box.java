class Solution {
    char[][] ret;

    public char[][] rotateTheBox(char[][] boxGrid) {
        ret = new char[boxGrid[0].length][boxGrid.length];

        for (int i = boxGrid.length - 1; i >= 0; i--) {
            int stoneCnt = 0;
            int prevBlockIdx = -1;
            for (int j = boxGrid[i].length - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    stoneCnt++;
                }

                if (boxGrid[i][j] == '*' || j == 0) {
                    for (int k = prevBlockIdx + 1; k < boxGrid[i].length - j; k++) {
                        if (stoneCnt-- > 0) {
                            ret[boxGrid[i].length - k - 1][boxGrid.length - i - 1] = '#';
                        } else if (boxGrid[i].length - k - 1 == j && boxGrid[i][j] == '*') {
                            ret[boxGrid[i].length - k - 1][boxGrid.length - i - 1] = '*';
                        } else {
                            ret[boxGrid[i].length - k - 1][boxGrid.length - i - 1] = '.';
                        }
                    }
                    stoneCnt = 0;
                    prevBlockIdx = boxGrid[i].length - j - 1;
                }
            }
        }
        return ret;
    }
}