class Solution {
    public int longestConsecutive(int[] nums) {
        //using HashMap

        Map<Integer,Boolean> map = new HashMap<>();
        int maxLen = 0;

        for(int n : nums){
            map.put(n, false);
        }

        for(int n : nums){
            int currLen =1;
            int nextNum = n+1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                currLen++;
                map.put(nextNum,true);
                nextNum++;
            }

            int prevNum = n-1;
            while(map.containsKey(prevNum) && map.get(prevNum) == false){
                currLen++;
                map.put(prevNum,true);
                prevNum--;
            }
            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;


    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        Arrays.sort(nums);
        int count =1, maxLen =1;
        for(int i = 0 ; i < nums.length-1; i++){
            if(nums[i+1] == nums[i]+1){
                count++;

                if(count > maxLen){
                    maxLen = count;
                }
            }
            else if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                count =1;
            }
        }
        return maxLen;
    }
}

// TC: O(nlogn)
// SC: O(1)