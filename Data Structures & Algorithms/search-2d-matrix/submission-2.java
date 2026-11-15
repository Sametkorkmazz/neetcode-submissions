class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row;
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (target > matrix[middle][matrix[middle].length - 1]) {
                l = middle + 1;
            } else if (target < matrix[middle][0] ) {
                r = middle - 1;
            } else {
                break;
            }
        }
        if (l > r) {
            return false;
        }
        row = (l + r) / 2;
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