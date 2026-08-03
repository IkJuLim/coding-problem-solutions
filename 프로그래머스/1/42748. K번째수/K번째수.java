import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] numCnt = new int[101];

        for (int i = 0; i < commands.length; i++) {
            Arrays.fill(numCnt, 0);
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                numCnt[array[j]]++;
            }

            int idx = 1;
            while (commands[i][2] > 0) {
                commands[i][2] -= numCnt[idx];
                idx++;
            }
            answer[i] = idx - 1;
        }

        return answer;
    }
}