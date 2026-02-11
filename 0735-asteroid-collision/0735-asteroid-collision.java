import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        s.add(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (s.size() > 0 && asteroids[i] < 0 && s.peek() > 0) {
                if (asteroids[i] * -1 == s.peek()) {
                    s.pop();
                    continue;
                } else if (asteroids[i] * -1 > s.peek()) {
                    s.pop();
                    i--;
                    continue;
                } else {
                    continue;
                }
            }
            s.add(asteroids[i]);
        }
        return s.stream().mapToInt(i -> i).toArray();
    }
}