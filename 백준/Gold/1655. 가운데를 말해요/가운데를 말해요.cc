#include <iostream>
#include <vector>
#include <queue>
using namespace std;

priority_queue<int> Left;
priority_queue<int, vector<int>, greater<int>> Right;

int Insert(int i, int num){
    Left.push(num);
    if (Left.top() > Right.top()) {
        Left.pop();
        Right.push(num);
        if (Right.size() > Left.size()) {
            Left.push(Right.top());
            Right.pop();
        }
    }
    if (Left.size() - Right.size() > 1) {
        Right.push(Left.top());
        Left.pop();
    }
    return 0;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    Left.push(-100000);
    Right.push(100000);
    
    int n, num;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> num;
        Insert(i, num);
        cout << Left.top() << '\n';
    }
    return 0;
}