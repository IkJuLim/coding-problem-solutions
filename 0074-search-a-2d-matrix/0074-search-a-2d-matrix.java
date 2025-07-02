class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length * matrix[0].length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int idx = (s + e) / 2;

            if (matrix[idx / matrix[0].length][idx % matrix[0].length] == target){
                return true;
            }
            else if (matrix[idx / matrix[0].length][idx % matrix[0].length] > target){
                e = idx - 1;
            }
            else if (matrix[idx / matrix[0].length][idx % matrix[0].length] < target) {
                s = idx + 1;
            }
        }
        return false;
    }
}