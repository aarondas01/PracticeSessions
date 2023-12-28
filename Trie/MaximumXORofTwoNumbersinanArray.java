class Solution {
    //create the trie
    class Trie{
        Trie[] children;

        public Trie(){
            //size 2 becoz in binary there can be only two values 0 and 1
            children = new Trie[2];
        }
    }

    private Trie root;

    public int findMaximumXOR(int[] nums) {

        //using trie

        if(nums == null || nums.length == 0)
            return 0;

        //init Trie
        root = new Trie();


        //first of all insert all numbers bits into trie
        //insert all String bit representations of the numbers into the trie
        buildTrie(nums);

        int max = Integer.MIN_VALUE;

        // find the max number to get the max no of bits
        //to get max bits or bit length take log(2)(n)+1


        // convert each no into binary string
        // to maximize XOR take XOR with the negative bit of the no

        //check if the negative bit no is present in the array
        //if not, take the nearest negative bit that is present in the array

        //search the closest possible no to the negative bit from MSB to LSB
        //becoz MSB will give higher values
        for(int n : nums){
            int maxXORForNum = findMaxXORForCurrentNum(n);
            max = Math.max(max,maxXORForNum ^ n);
        }
        return max;


    }

    private void buildTrie(int[] nums){
        for(int n : nums){
            Trie currNode = root;
            // find the max number to get the max no of bits
            //to get max bits or bit length take log(2)(n)+1
            //here I am taking max 32 bit
            //32 bit trie
            for(int i = 31; i >= 0 ;i--){
                int currBit = (n>>>i) &1;
                if(currNode.children[currBit] == null){
                    currNode.children[currBit] = new Trie();
                }
                currNode = currNode.children[currBit];
            }
        }
    }
    private int findMaxXORForCurrentNum(int num){
        Trie currNode = root;
        int targetNum = 0;
        for(int i = 31; i >= 0 ; i--){
            int currBit = (num>>>i) & 1;
            int targetBit = currBit == 0 ? 1 : 0;
            if(currNode.children[targetBit] != null){
                targetNum = targetNum *2 + targetBit;
                currNode = currNode.children[targetBit];
            }
            else{
                targetNum = targetNum * 2 + currBit;
                currNode = currNode.children[currBit];
            }
        }
        return targetNum;
    }
}

// TC: O(n)
// SC: O(n)
