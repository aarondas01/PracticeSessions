class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //bfs

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()){
            int index = queue.poll();
            for(int i : rooms.get(index)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        for(int i = 0 ; i < rooms.size(); i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}

// SC: O(N)
// TC: O(N)



class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //dfs
        visited = new boolean[rooms.size()];
        visited[0] = true;

        dfs(rooms,0);

        for(boolean b : visited){
            if(!b)
                return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int index){
        for(int i : rooms.get(index)){
            if(!visited[i]){
                visited[i] = true;
                dfs(rooms, i);
            }
        }
    }
}
// TC: O(N)
// SC: O(N)

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //using stack
        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int count =1;
        while(stack.size()>0){
            int index = stack.pop();
            for(int i : rooms.get(index)){
                if(!visited[i]){
                    stack.push(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return rooms.size() == count;
    }
}

// TC: O(n)
// SC: O(n)

