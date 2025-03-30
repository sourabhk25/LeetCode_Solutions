class Solution {
    int[][] directions;
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        this.directions = new int[][]{{-1,-1}, {-1,0}, {-1, 1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        this.m = board.length;
        this.n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = getNeighborsCount(board, i, j); //gives no of alive neighbors count for cell (i,j)
                if(board[i][j] == 0 && count == 3) {        //becomes live
                    board[i][j] = 3; //dead -> alive case; we are using 0->1 = 3                    
                } else if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    //live becomes dead case
                    board[i][j] = 2;    //alive -> dead, we are using 1->0 = 2
                }
            }
        }

        //now change 2 and 3 to 0 and 1 respectively
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int getNeighborsCount(int[][] board, int i, int j) {
        int count = 0;
        for(int[] dir: directions) {    //go through direction array and find all 8 neighbors
            int r = i + dir[0];
            int c = j + dir[1];

            if(r >= 0 && c >= 0 && r < m && c < n) {    //valid neigbors cells index i.e. not out of bounds
                if(board[r][c] == 1 || board[r][c] == 2) {
                    //alredy 1 value or changed to 2 i.e. alive became dead in previous iterations or not
                    count++;
                }
            }
        }

        return count;
    }
}