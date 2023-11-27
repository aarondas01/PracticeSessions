class Solution {
    public int largestRectangleArea(int[] heights) {
        //brute force
        // at each index find a left and right boundary between which the height of the
        //rectangle is atleast equal to current height

        //using array



        int n = heights.length;
        int maxArea = 0;
        if(n==0){
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = -1;
        right[n-1] = n;

        //in left array
        // for each index go to left and find the nearest index where height[index] < height[curr]
        for(int i =1 ; i<n ;i++){
            int prev = i-1;
            while(prev >=0 && heights[prev] >= heights[i]){
                prev = left[prev];
            }
            left[i] = prev;
        }

        //in right array
        //for each index go to the right and find the nearest index where height[index] < height[curr]

        for(int i = n-2; i >=0; i--){
            int prev=i+1;
            while(prev < n && heights[prev] >= heights[i]){
                prev = right[prev];
            }
            right[i] = prev;
        }

        for(int i = 0 ; i <n ;i++){
            int width = right[i] - left[i] -1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;

    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        //optimized using stack

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i <= n ; i++){
            int currHeight = i==n ? 0 : heights[i];

            //currHeight  > heights[top] then push otherwise pop and find area
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i-stack.peek()-1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

// TC: O(N)
// SC: O(N)