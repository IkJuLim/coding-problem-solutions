#include "iostream"
#include "string"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string temp;

    while (getline(cin, temp)) {
        cout << temp << "\n";
    }
    return 0;
}