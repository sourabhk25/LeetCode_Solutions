class Solution {
    int[][] dirs;
    int m,n;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        this.m = mat.length;
        this.n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();    //stores index of 0s

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] *= -1;
                }
            }
        }

        int dist = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r >= 0 && c >= 0 && r <m && c < n && mat[r][c] == -1) { //if valid cell  
                    q.add(new int[]{r, c});
                    mat[r][c] = mat[curr[0]][curr[1]] + 1; //distance will be +1 than the neighbor
                }
            }
        }

        return mat;
    }
}