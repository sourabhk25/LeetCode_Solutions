#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isIsomorphic(string s, string t){
        if(s.length() != t.length()){
            return false;
        } else{
            map<char, int> sMap, tMap;
            map<char, int>::iterator itS, itT;
            map<char, char> charMap;
            map<char, char>::iterator itChar;
            bool ret;
            for(int i=0; i<s.length(); i++){
                itS = sMap.find(s[i]); 
                if(itS == sMap.end()){   
                    sMap.insert(pair<char, int>(s[i],0));
                } else{
                    itS->second++; 
                }

                itT = tMap.find(t[i]); 
                if(itT == tMap.end()){   
                    tMap.insert(pair<char, int>(t[i],0));
                } else{
                    itT->second++; 
                }

                //compare related map
                itChar = charMap.find(s[i]);
                if(itChar == charMap.end()){   
                    charMap.insert(pair<char, char>(s[i], t[i]));
                } else{
                    if(itChar->second != t[i]){
                        ret = false;
                        return ret;
                    }				
                } 
                
            }
            

            int count = 0;
            for(int i=0; i<t.length(); i++){
                if((sMap.find(s[i])->second == tMap.find(t[i])->second)){
                    count++;
                }
            }
            if(count == t.length()){
                ret = true;
            } else{
                ret = false;
            }

            return ret;
        }
    }
};