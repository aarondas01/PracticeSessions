class Solution {

    class UnionFind{
        int[] ar;
        UnionFind(int len){
            ar = new int[len];
            for(int i = 0 ; i < len ; i++){
                ar[i] = i;
            }
        }

        int find(int x){
            if(x!= ar[x]){
                ar[x]= find(ar[x]);
            }
            return ar[x];
        }

        void union(int x, int y){
            ar[find(x)] = ar[find(y)];
        }
    }
    public int largestComponentSize(int[] nums) {
        int maxVal = Integer.MIN_VALUE;

        for(int n : nums){
            maxVal = Math.max(maxVal,n);
        }

        UnionFind uf = new UnionFind(maxVal +1);
        for(int n : nums){
            for(int i =2 ; i <= Math.sqrt(n); i++){
                if(n%i == 0){
                    uf.union(n,i);
                    uf.union(n, n/i);
                }
            }
        }

        int max =1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            int parent = uf.find(n);
            map.put(parent, map.getOrDefault(parent,0)+1);
            max= Math.max(max, map.get(parent));
        }
        return max;
    }
}

// TC: O(n*n)
// SC: O(n)