class TimeMap {
    HashMap<String, TreeMap<Integer, String>> hmap; //TreeMap used to get sorted map according to timestamp
    
    public TimeMap() {
        hmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hmap.containsKey(key)) {
            hmap.put(key, new TreeMap<>()); //create bucket for a new key  
        }
        hmap.get(key).put(timestamp, value);    //add timestamp and value to bucket
    }
    
    public String get(String key, int timestamp) {
        if(hmap.containsKey(key)) { //check if hmap contains key or not
            TreeMap<Integer, String> tmap = hmap.get(key);  //get treemap for key
            Integer prevTime = tmap.floorKey(timestamp);    //binary search using floorKey
            if(prevTime != null) {  //if found
                return tmap.get(prevTime);  //return value at prevKey
            }
        }
        return "";  //return empty string for key not found or value not found cases
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */