class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (s.size() > 0 && asteroids[i] < 0 && s.peek() > 0) {
                if (asteroids[i] * -1 == s.peek()) s.pop();
                else if (asteroids[i] * -1 > s.peek()) {
                    s.pop();
                    i--;
                }
            } else s.add(asteroids[i]);
        }
        return s.stream().mapToInt(i -> i).toArray();
    }
}