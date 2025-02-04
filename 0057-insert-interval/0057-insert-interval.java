class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> resultList = new ArrayList<>();
    for(int[] interval : intervals) {
      if(newInterval[0] > interval[1]) {
        resultList.add(interval);
      }
      else if(interval[0] > newInterval[1]){
        resultList.add(newInterval);
        newInterval = interval;
      }
      else {
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      }
    }

    resultList.add(newInterval);

    return resultList.toArray(new int[resultList.size()][]);
  }
}