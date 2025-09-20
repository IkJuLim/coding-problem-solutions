class BrowserHistory {

  List<String> history;
  int idx;

  public BrowserHistory(String homepage) {
    history = new LinkedList<>();
    history.add(homepage);
    idx = 0;
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
  }

  public String back(int steps) {
    idx -= Math.min(idx, steps);
    return history.get(idx);
  }

  public String forward(int steps) {
    idx = Math.min(idx + steps, history.size() - 1);
    return history.get(idx);
  }
}