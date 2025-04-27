class Solution {
    //using DFS
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    DFS(grid, i ,j);    //call DFS function with that start point
                }
            }
        }
        
        return count;
    }
    
    private void DFS(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';   //change 1 to 0 so that we can know that it is visited
        //next call DFS recursively for up, down, left, right cells
        DFS(grid, i-1, j);    //up
        DFS(grid, i+1, j);    //down
        DFS(grid, i, j-1);    //left
        DFS(grid, i, j+1);    //right
    }
}