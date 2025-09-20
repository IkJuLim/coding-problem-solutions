class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    int ret = 0;
    int[] boxes = new int[1001];
    for(int[] i : boxTypes){
      boxes[i[1]] += i[0];
    }
    for(int i = 1000; i > 0; i--){
      if(boxes[i] < truckSize){
        ret += boxes[i] * i;
        truckSize -= boxes[i];
      }
      else{
        ret += truckSize * i;
        break;
      }
    }
    return ret;
  }
}