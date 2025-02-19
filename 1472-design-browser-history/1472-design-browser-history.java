class BrowserHistory {

  List<String> history;
  int idx;

  public BrowserHistory(String homepage) {
    history = new LinkedList<>();
    history.add(homepage);
    idx = 0;
    System.out.println(idx);
  }

  public void visit(String url) {
    if (idx + 1 < history.size()) {
      history.set(idx + 1, url);
    } else {
      history.add(url);
    }
    idx++;
    while (idx + 1 < history.size()) {
      history.remove(idx + 1);
    }
    System.out.println(idx);
  }

  public String back(int steps) {
    idx -= Math.min(idx, steps);
    System.out.println(idx);
    return history.get(idx);
  }

  public String forward(int steps) {
    idx = Math.min(idx + steps, history.size() - 1);
    System.out.println(idx);
    return history.get(idx);
  }
}