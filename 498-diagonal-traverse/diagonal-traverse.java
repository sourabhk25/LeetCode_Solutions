class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Boolean dir = true;    //true means upward and false means downwards
        int[] output = new int[m * n];
        int r = 0, c = 0;   //iterators for matrix
        for(int i = 0; i < m*n; i++) {
            output[i] = mat[r][c];
            if(dir) {   //upward direction
                if(r == 0 && c != n - 1) {  //first row but not last column, so go to next column and go downwards  -> 1 in eg-1
                    c++; 
                    dir = false;
                } else if(c == n - 1) {    //last column so go to next row and go downwards -> 3 in eg-1
                    r++;
                    dir = false;
                } else {    //normal up case like 5 in eg-1
                    r--;
                    c++;
                }
            } else {    //downwards direction
                if(c == 0 && r != m - 1) {  //0th column but not last row, 4 in eg-1
                    r++;    //go to next row and go upward
                    dir = true;
                } else if(r == m - 1) { //last row-> 8 in eg-1
                    c++;
                    dir = true;
                }
                else {  //normal downwards -> 6 in eg-1
                    r++;
                    c--;
                }
            }
        }

        return output;
    }
}