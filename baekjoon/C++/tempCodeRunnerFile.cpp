#include<iostream>
#include<cmath>
using namespace std;  

int main(){ 
    int T;
    cin >> T;
    for (int i = 0; i < T; i++){
        int x1, y1, r1, x2, y2, r2, d;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        d = sqrt(pow(x1-x2, 2)*pow(y1-y2, 2));
        if(d==0 && r1==r2)
            cout << -1 << endl;
        else if(d > r1 + r2 || d < abs(r1 - r2))
            cout << 2 << endl;
		else if (d == r1 + r2 || d == abs(r1 - r2)) {
			cout << 1 << endl;
		}
		else if (d < r1 + r2) {
			cout << 2 << endl;
		}
    }
}