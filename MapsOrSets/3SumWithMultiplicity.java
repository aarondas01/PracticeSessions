class Solution {
    public int threeSumMulti(int[] arr, int target) {
        //brute force
        long mod = (long)1e9+7;
        long result  = 0;
        for(int i = 0 ; i < arr.length; i++){
            int[] count = new int[101];
            for(int j = i+1; j < arr.length ; j++){
                int k = target - arr[i] - arr[j];
                if(k >= 0 && k <= 100  && count[k]>0){
                    result += count[k];
                    result %= mod;
                }
                count[arr[j]]++;
            }
        }
        return (int) result;

    }
}

// TC: O(n^2)
// SC: O(1)

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        //using HashMap

        Map<Integer, Long> freqMap = new HashMap<>();
        for(int n: arr){
            long freq = freqMap.getOrDefault(n, 0l);
            freqMap.put(n, freq+1l);
        }

        long result =0;
        for(Integer i: freqMap.keySet()){
            for(Integer j : freqMap.keySet()){
                int k = target -i -j;
                if(freqMap.containsKey(k)){
                    long freq1 = freqMap.get(i);
                    long freq2 = freqMap.get(j);
                    long freq3 = freqMap.get(k);

                    if(i == j && i ==k){
                        result += ((freq1) * (freq1-1)*(freq1-2))/6;
                    } else if(i ==j && i!=k){
                        result += ((freq1)*(freq1-1))/2 *freq3;
                    } else if(i< j && j<k){
                        result += ((freq1*freq2 *freq3));
                    }

                }
                result = result % 1000000007;
            }
        }
        return (int) result;
    }
}

// TC: O(n^2)
// SC: O(n)