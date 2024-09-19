class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        //follow lowest common ancestor problem
        //create region and parent map, 
        //then store all parents for region 1 in a set
        //then find lowest common ancestor for region 2
        //kind of similar approach like LC#160
        Map<String, String> regionToParent = new HashMap<>();
        for(List<String> list: regions) {
            String parent = list.get(0);
            for(int i = 1; i < list.size(); i++) {
                regionToParent.put(list.get(i), parent);    //like (asia, earth)
            }
        }
        Set<String> region1Parents = new HashSet<>();
        while(region1 != null) {
            region1Parents.add(region1);    //region is parent to himself as well like LC#1650
            region1 = regionToParent.get(region1);
        }

        while(region2 != null) {    //now check region and traverse it till root while checking parent is present in parents set of region1
            if(region1Parents.contains(region2)) {
                return region2;
            }
            region2 = regionToParent.get(region2);
        }

        return null;    //if no LCA or no common region

    }
}