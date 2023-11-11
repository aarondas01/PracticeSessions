class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1){
            set1.add(n);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int n : nums2){
            set2.add(n);
        }

        List<Integer> list1 = new ArrayList<>();
        for(int i : set1){
            if(!set2.contains(i)){
                list1.add(i);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for(int j : set2){
            if(!set1.contains(j)){
                list2.add(j);
            }
        }

        return Arrays.asList(list1,list2);
    }
}

// TC: O(m+n)
// SC: O(m+n)