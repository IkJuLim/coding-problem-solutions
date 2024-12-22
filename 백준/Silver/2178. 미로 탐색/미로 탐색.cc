#include <iostream>
#include <queue>

using namespace std;

int N, M;
int map[101][101] = {0, };
int length[101][101] = {1, };
bool visited[101][101] = {false, };

int bfs(int x, int y){
    queue< pair<int, int> > q;
    q.push(pair<int, int>(x, y));
    visited[x][y] = true;
    while(!q.empty()){
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        
        if(cx == N-1 && cy == M-1)
            break;

        if(cx + 1 <= N && !visited[cx + 1][cy] && map[cx + 1][cy] == 1){
            q.push(pair<int, int>(cx + 1, cy));
            length[cx + 1][cy] = length[cx][cy] + 1;
            visited[cx + 1][cy] = true;
        }
        if(cx - 1 >= 0 && !visited[cx - 1][cy] && map[cx - 1][cy] == 1){
            q.push(pair<int, int>(cx - 1, cy));
            length[cx - 1][cy] = length[cx][cy] + 1;
            visited[cx - 1][cy] = true;
        }
        if(cy + 1 <= M && !visited[cx][cy + 1] && map[cx][cy + 1] == 1){
            q.push(pair<int, int>(cx, cy + 1));
            length[cx][cy + 1] = length[cx][cy] + 1;
            visited[cx][cy + 1] = true;
        }
        if(cy - 1 >= 0 && !visited[cx][cy - 1] && map[cx][cy - 1] == 1){
            q.push(pair<int, int>(cx, cy - 1));
            length[cx][cy - 1] = length[cx][cy] + 1;
            visited[cx][cy - 1] = true;
        }
    }
    return length[N-1][M-1];
}

int main() {
    scanf("%d %d", &N, &M);
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%1d", &map[i][j]);
        }
    }

    printf("%d\n", bfs(0, 0));
}