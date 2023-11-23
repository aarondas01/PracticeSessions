class Solution {
    long maxScore; // stores the maximum score
    int count; // store the count of maximum score
    public int countHighestScoreNodes(int[] parent) {
        int n=parent.length;

        // creating the tree
        List<Integer> list[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            list[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            list[parent[i]].add(i);
        }

        maxScore=0l;
        count=0;

        dfs(0,list,n);

        return count;
    }

    // returns the number of nodes in the subtree with root u.
    public int dfs(int u, List<Integer> list[], int n){

        int total=0; // stores total number of nodes in the subtree with root u, excluding u.
        long prod=1l,rem,val;

        // traversing children in the subtree
        for(int v:list[u]){
            val=dfs(v,list,n); // number of nodes in the subtree with root v.
            total+=val;
            prod*=val;
        }
        rem=(long)(n-total-1); // number of nodes in the remaining tree excluding the subtree with root u.

        if(rem>0)// only count the remaining part if there is at least one node.
            prod*=rem;

        // updating maxScore and count.
        if(prod>maxScore){
            maxScore=prod;
            count=1;
        }
        else if(prod==maxScore){
            count++;
        }

        return total+1; // returning total number of nodes in the subtree with node u.
    }
}

// TC: O(v+e)
// SC: O(v+e)