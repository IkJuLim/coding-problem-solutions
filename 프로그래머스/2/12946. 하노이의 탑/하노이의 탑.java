import java.util.ArrayList;
import java.util.List;

class Solution {
    private int index = 0;
    private int[][] answer;

    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n) - 1][2];
        
        hanoi(n, 1, 3, 2);
        
        return answer;
    }

    private void hanoi(int n, int currTower, int destTower, int tmpTower) {
        if(n == 1)
            answer[index++] = new int[] {currTower, destTower};
        else{
            hanoi(n-1, currTower, tmpTower, destTower);
            answer[index++] = new int[] {currTower, destTower};
            hanoi(n-1, tmpTower, destTower, currTower);
        }
    }
}