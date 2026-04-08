class Solution {
    List<String> ret;
    Map<String, List<Integer>> map;

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        ret = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            int time = ((keyTime[i].charAt(0) - '0') * 10 + (keyTime[i].charAt(1) - '0')) * 60 + (keyTime[i].charAt(3) - '0') * 10 + (keyTime[i].charAt(4) - '0');
            List<Integer> list = map.getOrDefault(keyName[i], new ArrayList<>());
            list.add(time);
            map.put(keyName[i], list);
        }

        for (String name : map.keySet()) {
            List<Integer> timeList = map.get(name);
            find(name, timeList);
        }

        Collections.sort(ret);
        return ret;
    }

    private void find(String name, List<Integer> timeList) {
        Collections.sort(timeList);
        for (int i = 0; i < timeList.size() - 2; i++) {
            if (timeList.get(i + 2) - timeList.get(i) <= 60) {
                ret.add(name);
                return;
            }
        }
    }
}