class Solution {
    public int minimumTime(String s) {
        //use prefix suffix approach
        // take two arrays - from left to right and right to left
        // for each index check whether removing from left up till index or removing it from
        // middle whichever is lower
        //if value is 0 copy the previous value
        //if value is 1 add 2 as it is middle value and check if it is lower than the value in
        //  moving    from   left or right
        // do this for the right side as well
        //add the values in the arrays

        //finally compare the best way to split operations amongst the two arrays
        // left[i] + right[i+1]
        //pick the minimum value

        int n = s.length();
        int min = s.length();
        int[] nums = new int[n];


        //convert the string into integer
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        int[] leftCost = new int[n];
        leftCost[0] = nums[0];

        for (int i = 1; i < n; i++) {
            leftCost[i] = Math.min(i+1, leftCost[i - 1] + (nums[i] == 1? 2: 0));
        }

        int[] rightCost = new int[n];
        rightCost[n-1] = nums[n-1];

        for (int i = n-2; i >= 0; i--) {
            rightCost[i] = Math.min(n - i, rightCost[i + 1] + (nums[i] == 1? 2: 0));
        }
        for (int i = 0; i < n; i++) {
            int right = (i == n-1) ?  0 : rightCost[i+1];
            int left = leftCost[i];
            min = Math.min(min, left +right);
        }

        return min;
    }
}

// TC: O(n)
// SC: O(n)