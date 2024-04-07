#include "iostream"
#include "string"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    for (int i = 0; i < T; i++) {
        string temp;
        cin >> temp;
        cout << temp[0] << temp[temp.size() - 1] << "\n";
    }
    return 0;
}