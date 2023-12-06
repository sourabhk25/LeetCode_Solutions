class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> hmap; //ArrayList used here because it is mentioned that timestamps will be in sorted order
    //we will implement our own binary search
    
    public TimeMap() {  //constructor
        hmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {  //set function
        if(!hmap.containsKey(key)) {
            hmap.put(key, new ArrayList<>()); //create bucket for a new key  
        }
        hmap.get(key).add(new Pair(timestamp, value));    //add timestamp and value to bucket
    }
    
    public String get(String key, int timestamp) {  //get function
        if(!hmap.containsKey(key)) {    //return "" if key not found in hmap
            return "";
        }
        
        if(timestamp < hmap.get(key).get(0).getKey()) {
            return "";  //case for timestamp is less than lowest timestamp value in map
        }

        //binary search
        int low = 0;
        int high = hmap.get(key).size();    //did size() and not size()-1 because high will store the index of found key
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(hmap.get(key).get(mid).getKey() <= timestamp) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if(high == 0) { //means no timestamp is present before target one
            return "";
        }

        return hmap.get(key).get(high - 1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */