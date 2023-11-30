class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //count of AP subsequence with atleast 3 elements
        //create hashMap for each element which store thes the count of AP ending at that
        //point with more than 2 elements
        // <common difference, count of elements>




        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer>[] map = new Map[len];

        for (int i = 0; i < len; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long)(nums[j]) - nums[i];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                //convert the long diff to int diff
                int dif = (int)diff;
                int n2 = map[i].getOrDefault(dif, 0);
                int n1 = map[j].getOrDefault(dif, 0);
                ans += n1;
                int freq = n1 + n2 +1;
                map[i].put(dif, freq);
            }
        }

        return ans;
    }
}

// TC: O(n^2)
// SC: O(n^2)