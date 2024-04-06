#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, X, A[10001];

    cin >> N >> X;

    for (int i = 0; i < N; i++) {
        int temp;
        cin >> temp;
        if(temp < X)
            cout << temp << " ";
    }
    cout << endl;
    return 0;
}