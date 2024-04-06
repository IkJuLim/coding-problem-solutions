#include "iostream"

using namespace std;

int main(){
    long long N, M;
    cin >> N >> M;
    if (N - M < 0)
        cout << (M - N) << endl;
    else
        cout << (N - M) << endl;
    return 0;
}