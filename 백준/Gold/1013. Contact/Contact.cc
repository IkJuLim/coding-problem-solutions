#include <iostream>
#include <regex>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    string str;
    cin >> t;
    regex re("(([1][0][0]+[1]+)|([0][1]))+");
    while(t--){
        cin >> str;
        if (regex_match(str, re))
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }
    return 0;
}
