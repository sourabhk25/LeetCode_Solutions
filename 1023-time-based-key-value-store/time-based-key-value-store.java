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
        if(!hmap.containsKey(key)) {    //if key doesn't exist in hmap
            return "";  
        }
        TreeMap<Integer, String> tmap = hmap.get(key);
        Integer prevTime = tmap.floorKey(timestamp);    //search timestamp value
        if(prevTime == null) {
            return "";
        } else {
            return tmap.get(prevTime);  //return value at prevTime
        }

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */