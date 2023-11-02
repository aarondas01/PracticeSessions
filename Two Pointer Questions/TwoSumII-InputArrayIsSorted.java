class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //two pointer
        int left  = 0 , right = numbers.length -1;
        while(left< right){
            int sum= numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
// TC: O(n)
// SC: O(1)


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //using HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{ map.get(target-numbers[i]), i+1};
            }
            map.put(numbers[i], i+1);
        }
        return new int[]{-1,-1};
    }
}

// TC: O(n)
// SC: O(n)