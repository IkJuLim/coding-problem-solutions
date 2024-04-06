#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    bool check[31] = {false, };
    for (int i = 1; i <= 28; i++) {
        int temp;
        cin >> temp;
        check[temp] = true;
    }

    for (int i = 1; i <= 30; i++) {
        if (!check[i])
            cout << i << endl;
    }

    return 0;
}