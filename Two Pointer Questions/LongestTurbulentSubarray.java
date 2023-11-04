Longest Turbulent Subarray

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        //two pointer
        if(arr.length < 2){
            return arr.length;
        }

        int maxLen = 1;
        int start = 0 , end  = 0;
        int len = arr.length;

        while(start +1 < len){
            if(arr[start] == arr[start+1]){
                start++;
                continue;
            }
            end = start +1;
            while(end +1  < len && isTurbulent(arr,end)){
                end +=1;
            }
            maxLen = Math.max(maxLen, end-start+1);
            start = end;
        }
        return maxLen;
    }

    private boolean isTurbulent(int[] arr , int k){
        if((arr[k]> arr[k-1] && arr[k] > arr[k+1]) || (arr[k] < arr[k-1]) && (arr[k] < arr[k+1])){
            return true;
        }
        return false;
    }
}
// TC: O(n)
// SC: O(1)