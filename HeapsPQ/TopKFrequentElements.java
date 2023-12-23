class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //using buckets
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }


        for(int key : map.keySet()){
            int freq = map.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int count = 0;
        for(int i = bucket.length-1;  i >=0 && count < k ; i--){
            if(bucket[i] != null){
                for(int n : bucket[i]){
                    res[count++] = n;
                }
            }
        }
        return res;
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //using HashMap

        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (map.get(a)-map.get(b)));

        for(int key : map.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            res[i]= pq.poll();
        }

        return res;
    }
}

// TC: O(nlogk)
// SC: O(n+k)
