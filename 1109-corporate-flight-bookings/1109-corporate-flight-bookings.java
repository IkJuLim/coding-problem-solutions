class Solution {
  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] ret = new int[n];
    for(int[] booking : bookings) {
      for (int i = booking[0] - 1; i < booking[1]; i++) {
        ret[i] += booking[2];
      }
    }
    return ret;
  }
}