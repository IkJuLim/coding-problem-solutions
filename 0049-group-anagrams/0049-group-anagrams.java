class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
       
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
           
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                result.add(map.get(key));
            }
            map.get(key).add(str);
        }
       
        return result;
    }
}
