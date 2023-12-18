class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        Map<Integer,List<Integer>> map = new HashMap<>();
        //<num, indexes>


        for(int i = 0 ;i < n ; i++){
            List<Integer> indexes = map.getOrDefault(arr[i] ,new ArrayList<>());
            indexes.add(i);
            map.put(arr[i],indexes);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited = new boolean[n];

        int steps =0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- >0){
                int curr = queue.poll();
                int left = curr -1;
                int right = curr+1;

                if(curr == n-1){
                    return  steps;
                }
                if(curr< 0 || curr >= n || visited[curr]){
                    continue;
                }
                if(left > 0 && !visited[left]){
                    queue.offer(left);
                }
                if(right < n && !visited[right]){
                    queue.offer(right);
                }
                if(map.containsKey(arr[curr])){
                    for(int index : map.get(arr[curr])){
                        if(index >=0  && index < n && !visited[index]){
                            queue.offer(index);
                        }
                    }
                    map.remove(arr[curr]);
                }
                visited[curr] = true;

            }
            steps++;
        }
        return -1;
    }
}

// TC: O(n^2)
// SC: O(n)