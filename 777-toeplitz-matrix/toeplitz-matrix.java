class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // compare with top-left element everytime
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                if(r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c]) {    //compare if r, c>0 and top left is same as current
                    return false;   //if not same return false
                }
            }
        }
        return true;    //return true if whole loop is complete without exiting
    }
}