class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //atmost 2 MHTs are possible since we need to find the nodes which can be in the center of a forest/graph if we assume, 1/2 depend on no. of nodes and edges
        //BFS approach
        //we will delete nodes with degree 1 and if someone's degree becomes 1 add them in queue
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> degree = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        //create adjacency list and initialize degree to 0
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            degree.add(0);
        }

        //add edges and calculate degrees
        for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);  //adding double since undirected graph
            degree.set(e[0], degree.get(e[0]) + 1);     //incerase degrees of both nodes
            degree.set(e[1], degree.get(e[1]) + 1);
        }

        //add nodes with degree 1 to queue to start BFS
        for(int i = 0; i < n; i++) {
            if(degree.get(i) == 1) {
                queue.offer(i);
            }
        }

        //start classic BFS
        while(!queue.isEmpty()) {
            int s = queue.size();   //get size queue at each level
            ans.clear();    //clear ans list level by level
            for(int i = 0; i < s; i++) {    //loop in size of queue
                int front = queue.poll();   //get front node
                ans.add(front); //add node to ans
                for(int child: graph.get(front)) {  //loop in all children for the node
                    degree.set(child, degree.get(child) - 1);   //reduce degree by 1
                    if(degree.get(child) == 1) {    //if degree becomes 1 add to queue
                        queue.offer(child);
                    }
                }
            }
        }
        
        if(n == 1) {
            ans.add(0);
        }

        return ans;
    }
}