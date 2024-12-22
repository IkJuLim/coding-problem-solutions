class Solution {
public:
    int minAddToMakeValid(string s) {
        int ret = 0;
        int cnt = 0;
        for(int i = 0; i < s.size(); i++){
            if(cnt >= 0 && s[i] == '('){
                cnt++;
            }
            else if(cnt > 0 && s[i] == ')'){
                cnt--;
            }
            else if(cnt == 0 && s[i] == ')'){
                ret++;
            }
        }
        return cnt + ret;
    }
};