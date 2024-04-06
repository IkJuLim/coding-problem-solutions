#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, v, numbers[101], cnt = 0;
    cin >> n;

    for(int i = 0; i < n; i++){
        int temp;
        cin >> temp;
        numbers[i] = temp;
    }

    cin >> v;

    for (int i = 0; i < n; i++)
        if(numbers[i] == v)
            ++cnt;

    cout << cnt;

    return 0;
}