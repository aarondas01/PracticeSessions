class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //BFS
        // Topological Sort
        int[] result = new int[numCourses];

        List<Integer> tempList = new ArrayList<>();

        if(prerequisites == null){
            return result;
        }

        int[] indegree = new int[numCourses];
        // <course, prequisites>
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] temp : prerequisites){
            int course = temp[0];
            int prereq = temp[1];

            if(!map.containsKey(prereq)){
                map.put(prereq,new ArrayList<>());
            }
            map.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            Integer n = queue.poll();
            tempList.add(n);
            if(map.containsKey(n)){
                List<Integer> temp = map.get(n);
                for(Integer t : temp){
                    indegree[t]--;
                    if(indegree[t] == 0){
                        queue.add(t);
                    }
                }
            }
        }

        if(tempList.size() != numCourses){
            return new int[0];
        }
        for(int i = 0 ; i < numCourses; i++){
            result[i] = tempList.get(i);
        }
        return result;
    }
}

// TC: O(V+E)
// SC: O(V+E)