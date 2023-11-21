class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //when you traverse inorder in a BST the order is sorted
        //use inorder traversal to get  two lists
        //merge two sorted lists
        List<Integer> list1 = new ArrayList<>();
        inorderTraversal(root1,list1);

        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root2,list2);

        return mergeLists(list1,list2);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }

    private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();

        int start1= 0;
        int len1 = list1.size();

        int start2 = 0;
        int len2 = list2.size();

        while(start1 < len1 && start2 < len2){
            if(list1.get(start1)< list2.get(start2)){
                result.add(list1.get(start1));
                start1++;
            }
            else{
                result.add(list2.get(start2));
                start2++;
            }
        }

        while(start1 < len1){
            result.add(list1.get(start1));
            start1++;
        }

        while(start2 < len2){
            result.add(list2.get(start2));
            start2++;
        }
        return result;
    }
}

// TC: O(n)
// SC: O(n)