class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int idx = q.poll();
            if(arr[idx] == 0) return true;
            visited[idx] = true;
            if (idx + arr[idx] >= 0 && idx + arr[idx] < arr.length && !visited[idx + arr[idx]]) q.add(idx + arr[idx]);
            if (idx - arr[idx] >= 0 && idx - arr[idx] < arr.length && !visited[idx - arr[idx]]) q.add(idx - arr[idx]);
        }

        return false;
    }
}