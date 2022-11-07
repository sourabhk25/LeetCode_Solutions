#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSum(vector<vector<int>>& grid) {
        int sum = 0;
        int maxSoFar = INT32_MIN;
        for(int i=0;i+2<grid.size();i++){
            for(int j=0;j+2<grid[i].size();j++){
                sum = grid[i][j] + grid[i][j+1] + grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                maxSoFar = max(sum, maxSoFar);
            }
        }
        return maxSoFar;
    }
};