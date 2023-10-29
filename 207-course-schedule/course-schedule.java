class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedCount = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visitedCount++;

            for(int neighbor: adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visitedCount == numCourses;
    }
}