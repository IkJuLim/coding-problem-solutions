class Solution {
    List<String> ret;
    Map<String, List<int[]>> map;

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        ret = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            int[] time = Arrays.stream(keyTime[i].split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            List<int[]> list = map.getOrDefault(keyName[i], new ArrayList<>());
            list.add(time);
            map.put(keyName[i], list);
        }

        for (String name : map.keySet()) {
            List<int[]> timeList = map.get(name);
            timeList.sort((a, b) -> (a[0] * 60 + a[1]) - (b[0] * 60 + b[1]));

            find(name, timeList);
        }

        Collections.sort(ret);
        return ret;
    }

    private void find(String name, List<int[]> timeList) {
        for (int i = 0; i < timeList.size() - 2; i++) {
            int[] time1 = timeList.get(i);
            int[] time2 = timeList.get(i + 2);
            if ((time2[0] * 60 + time2[1]) - (time1[0] * 60 + time1[1]) <= 60) {
                ret.add(name);
                return;
            }
        }
    }
}