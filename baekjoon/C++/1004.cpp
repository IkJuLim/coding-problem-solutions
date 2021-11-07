#include <iostream>
#include<cmath>
using namespace std;

int main() {
    int T;
    cin >> T;

    for(int i = 0; i < T; i++) {
        int n, x1, x2, y1, y2, cnt = 0;
        bool in1, in2;
        cin >> x1 >> y1 >> x2 >> y2;
        cin >> n;

        for(int j = 0; j < n; j++) {
            int cx, cy, r, d;

            cin >> cx >> cy >> r;
            d = pow(cx-x1, 2) + pow(cy-y1, 2);
            in1 = d > r * r ? false : true;
            d = pow(cx-x2, 2) + pow(cy-y2, 2);
            in2 = d > r * r ? false : true;
            if (in1 != in2) 
                cnt++;
        }
        cout << cnt << endl;
    }
    return 0;
}