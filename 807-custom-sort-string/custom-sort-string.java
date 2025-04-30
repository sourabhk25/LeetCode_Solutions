class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        //add all freq from s in map
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: order.toCharArray()) {
            if(map.containsKey(c)) {
                int cnt = map.get(c);
                for(int k = 0; k < cnt; k++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        //in map we cant delete characters while iterating the map we get error since concurrent modification in map is not allowed in Java
        for(char c: map.keySet()) {
            int cnt = map.get(c);
            for(int k = 0; k < cnt; k++) {
                sb.append(c);
            }            
        }

        return sb.toString();
    }
}