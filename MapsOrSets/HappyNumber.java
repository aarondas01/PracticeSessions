
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(true){
            int sum = 0;

            while(n !=0){
                sum += Math.pow(n%10,2);
                n /=10;
            }

            if(sum ==1){
                return true;
            }
            n= sum;
            if(set.contains(sum)){
                return false;
            }
            set.add(n);
        }
    }
}

// TC: O(1)
// SC: O(1)

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(set.add(n)){
            int sum = 0;

            while(n != 0){
                sum += Math.pow(n%10,2);
                n /= 10;
            }
            if(sum ==1){
                return true;
            }
            else{
                n = sum;
            }
        }
        return  false;
    }
}