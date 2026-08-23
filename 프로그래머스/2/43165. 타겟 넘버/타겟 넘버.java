class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {

        solve(0, -1, numbers, target);

        return answer;
    }

    private void solve(int curr, int idx, int[] numbers, int target) {
        if (idx == numbers.length - 1) {
            if (curr == target) {
                answer++;
            }
            return;
        }
        solve(curr + numbers[++idx], idx, numbers, target);
        solve(curr - numbers[idx], idx, numbers, target);
    }
}