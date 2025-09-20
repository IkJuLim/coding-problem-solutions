class Solution {
  public String addBinary(String a, String b) {
    StringBuilder sbA = new StringBuilder(a);
    StringBuilder sbB = new StringBuilder(b);
    StringBuilder sb = new StringBuilder();

    if (sbA.length() > sbB.length()) {
      while(sbA.length() > sbB.length()) {
        sbB.insert(0, '0');
      }
    }
    if (sbA.length() < sbB.length()) {
      while(sbA.length() < sbB.length()) {
        sbA.insert(0, '0');
      }
    }

    boolean round = false;
    while (sbA.length() > 0 && sbB.length() > 0) {
      char cA = sbA.charAt(sbA.length() - 1);
      char cB = sbB.charAt(sbB.length() - 1);
      if (cA == '0' && cB == '0') {
        sb.insert(0, round ? '1' : '0');
        round = false;
      } else if (cA == '0' && cB == '1' || cA == '1' && cB == '0') {
        sb.insert(0, round ? '0' : '1');
      } else {
        sb.insert(0, round ? '1' : '0');
        round = true;
      }
      sbA.delete(sbA.length() - 1, sbA.length());
      sbB.delete(sbB.length() - 1, sbB.length());
    }


    if (round) {
      sb.insert(0, '1');
    }

    return sb.toString();
  }
}