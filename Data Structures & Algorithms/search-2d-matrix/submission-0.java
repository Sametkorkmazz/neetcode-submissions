class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row;
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (matrix[middle][0] > target) {
                r = middle - 1;
            } else if (matrix[middle][0] < target) {
                l = middle + 1;
            } else {
                return true;
            }
        }
        row = Math.min(l, r);
        row = Math.max(row, 0);
        l = 0;
        r = matrix[row].length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (matrix[row][middle] > target) {
                r = middle - 1;
            } else if (matrix[row][middle] < target) {
                l = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}