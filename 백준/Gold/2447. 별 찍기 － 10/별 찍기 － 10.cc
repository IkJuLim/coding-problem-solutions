#include <iostream>
using namespace std;

bool board[6561][6561];

void recall(int x_1, int y_1, int x_2, int y_2){
    if(x_1 == x_2 || y_1 == y_2)
        return;
    int size = x_2 - x_1 + 1;
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            int recallX_1 = i * (size / 3) + x_1;
            int recallY_1 = j * (size / 3) + y_1;
            int recallX_2 = (i + 1) * (size / 3) + x_1 - 1;
            int recallY_2 = (j + 1) * (size / 3) + x_1 - 1;
            recall(recallX_1, recallY_1, recallX_2, recallY_2);
        }
    }

    for(int i = (size / 3) + x_1; i < (size * 2 / 3) + x_1; i ++){
        for(int j = (size / 3) + y_1; j < (size * 2 / 3) + y_1; j ++)
            board[i][j] = true;
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;

    cin >> n;

    recall(0, 0, n - 1, n - 1);

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(!board[i][j])
                cout << "*";
            else
                cout << " ";
        }
        cout << "\n";
    }
    return 0;
}