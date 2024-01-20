/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {

        return helper(grid, 0,0,grid.length);
    }


    private Node helper(int[][] grid, int i, int j , int n){
        if(isAllSame(grid,i,j,n)){
            return new Node(grid[i][j] ==1 ? true : false, true);
        }

        Node node = new Node(false, false);
        node.topLeft = helper(grid, i, j, n/2);
        node.topRight = helper(grid, i, j + n/2, n/2);
        node.bottomLeft = helper(grid, i +n/2, j, n/2);
        node.bottomRight = helper(grid, i + n/2, j +n/2, n/2);

        return node;
    }


    private boolean isAllSame (int[][] grid, int i , int j , int n){
        for(int u= i ; u < i+n; u++){
            for(int v = j ; v < j + n; v++){
                if(grid[u][v] != grid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

// TC: O(n^2 * logn)
// SC: O(logn)