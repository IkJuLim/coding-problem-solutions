#include <iostream>
using namespace std;

long long fiboarr[40] = {0,1,};

long long fibo(int n){
    if(n == 0 || n == 1)
        return fiboarr[n];
    else if(fiboarr[n] == 0)
        fiboarr[n] = fibo(n-1) + fibo(n-2);
    return fiboarr[n];
}

int main() {
    int T;
    cin >> T;
    int N;
    for(int i = 0; i < T; i++) {
        cin >> N;
        if(N == 0)
            cout << "1 0" << endl;
        else
            cout << fibo(N-1) << " " << fibo(N) << endl;
    }
}