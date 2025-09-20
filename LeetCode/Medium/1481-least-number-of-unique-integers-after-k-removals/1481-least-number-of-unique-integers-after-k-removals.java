class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int a : arr)
      count.merge(a, 1, Integer::sum);

    Queue<Integer> pq = new PriorityQueue<>(count.values());
    while (k > 0) {
      k -= pq.poll();;
    }
    return pq.size() + (k < 0 ? 1 : 0);
  }
}