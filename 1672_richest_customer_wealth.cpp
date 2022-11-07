#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        vector<int> sumWealth;
        int columns=accounts[0].size();
        int rows=accounts.size();
        for(int i=0;i<rows;i++){
            int temp=0;
            for(int j=0;j<columns;j++){
                temp+=accounts[i][j];
            }
            sumWealth.push_back(temp);
        }
        sort(sumWealth.begin(),sumWealth.end());
        return sumWealth.back();
    }
};