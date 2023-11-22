
class Solution {
    private int[] res;
    private int[] count;
    private List<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        //calculate depth of each node from the root node
        //take the next node as the root node
        //again from each node count the depth and add it to the list
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[n];
        count = new int[n];

        for(int i = 0 ; i < n ; i++){
            tree.add(new HashSet<Integer>());
        }

        for(int[] ed : edges){
            tree.get(ed[0]).add(ed[1]);
            tree.get(ed[1]).add(ed[0]);
        }

        postOrder(0,-1);
        preOrder(0,-1);

        return res;
    }

    public void postOrder(int root, int pre){
        for(int i : tree.get(root)){
            if(i==pre){
                continue;
            }
            postOrder(i,root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }

    public void preOrder(int root, int pre){
        for(int i : tree.get(root)){
            if(i== pre){
                continue;
            }
            res[i] = res[root] - count[i] + count.length - count[i];
            preOrder(i,root);
        }
    }
}

// TC: O(n)
// SC: O(n)