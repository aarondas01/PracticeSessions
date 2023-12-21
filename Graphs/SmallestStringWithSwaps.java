class Solution {

    private class UnionFind{
        private int[] parent;

        private UnionFind(int n){
            parent = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }

        private int getAbsoluteParent(int i){
            if(parent[i] == i){
                return i;
            }
            parent[i]= getAbsoluteParent(parent[i]);
            return parent[i];
        }

        private void unify(int i , int j){
            int absoluteParent1 = getAbsoluteParent(i);
            int absoluteParent2 = getAbsoluteParent(j);
            if(absoluteParent1 != absoluteParent2){
                parent[absoluteParent2] = absoluteParent1;
            }

        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] str = s.toCharArray();

        // <ParentID, All charaacters that map to same parent>

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        UnionFind uf = new UnionFind(str.length);

        for(List<Integer> pair : pairs){
            uf.unify(pair.get(0), pair.get(1));
        }

        for(int i = 0 ; i < str.length; i++){
            int parentId = uf.getAbsoluteParent(i);
            PriorityQueue<Character> pq = map.getOrDefault(parentId, new PriorityQueue<Character>());
            pq.offer(str[i]);
            map.putIfAbsent(parentId,pq);
        }

        for(int i = 0 ;  i < str.length; i++){
            int parentId = uf.getAbsoluteParent(i);
            str[i] = map.get(parentId).poll();

        }
        return new String(str);
    }
}

// TC: O(N*N)
// SC: O(N)