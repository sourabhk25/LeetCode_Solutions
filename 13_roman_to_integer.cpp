#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        map<char, int> values;
        int sum = 0;
        values.insert(pair<char, int>('I', 1));
        values.insert(pair<char, int>('V', 5));
        values.insert(pair<char, int>('X', 10));
        values.insert(pair<char, int>('L', 50));
        values.insert(pair<char, int>('C', 100));
        values.insert(pair<char, int>('D', 500));
        values.insert(pair<char, int>('M', 1000));

        for(int i=0;i<s.length();i++){
            int current = values.find(s[i])->second;
            int next = values.find(s[i+1])->second;
            int toAdd;
            if(i != s.length()-1){
                if(next > current){
                    current = next - current;
                    i++;
                } 
            }
            sum += current;            
        }
        return sum;
    }
};