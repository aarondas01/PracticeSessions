class Solution {
    public int[] threeEqualParts(int[] arr) {
        int[] ans = new int[]{-1,-1};


        int n = arr.length;
        int countOnes = 0 ;

        for(int num : arr){
            if(num==1){
                countOnes++;
            }
        }

        if(countOnes == 0){
            return new int[]{0,n-1};
        }

        if(countOnes %3 != 0){
            return ans;
        }

        //no of ones in each part
        int k = countOnes/3;

        // indexOfFirstOne in each part
        int indexOnePart1 = -1;
        int indexOnePart2 = -1;
        int indexOnePart3 = -1;

        countOnes = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] ==1){
                countOnes++;

                if(countOnes ==1){
                    indexOnePart1 = i;
                }
                else if(countOnes == k+1){
                    indexOnePart2 = i;
                }
                else if(countOnes == 2*k+1){
                    indexOnePart3 = i;
                }

            }
        }

        while(indexOnePart3 < n){
            if(arr[indexOnePart3] == arr[indexOnePart1] && arr[indexOnePart3] == arr[indexOnePart2]){
                indexOnePart3++;
                indexOnePart2++;
                indexOnePart1++;


            }
            else{
                return ans;
            }
        }
        return new int[]{indexOnePart1-1,indexOnePart2};

    }
}

// TC: O(n)
// SC: O(1)



class Solution {
    public int[] threeEqualParts(int[] arr) {
        //all partitions must have equal number of 1s
        //countOfOne = 3k
        //each part should have k 1s




        // the equivalent decimal number in each partition must be equal

        //find the partition with equal number of ones

        //if countOfOne is 1,k+1, 2k+1 assign i1, i2,i3
        //if countOfOne is k, 2k, 3k assign j1, j2, j3

        int n = arr.length;
        int countOnes = 0;

        for(int num : arr){
            if(num ==1){
                countOnes++;
            }
        }

        if(countOnes % 3 != 0){
            return new int[]{-1,-1};
        }

        //if CountOfOne  =0, all nos are 0, return any three partitions
        if(countOnes == 0){
            return new int[]{0,n-1};
        }

        int k = countOnes/3;

        // to create partitions we need 6 variables
        int i1= -1, i2 =-1, i3 =-1;
        int j1=-1,  j2=-1,  j3 =-1;

        int currCount = 0;

        for(int i = 0; i < n ; i++){
            if(arr[i] == 1){
                currCount++;
                if(currCount == 1) i1 = i;
                if(currCount == (k+1)) i2 = i;
                if(currCount  == (2*k +1))  i3 = i;


                if(currCount == k) j1 = i;
                if(currCount == (2*k)) j2  = i;
                if(currCount == (3*k)) j3 = i;
            }
        }

        //compare the three partitions
        int[] part1 = Arrays.copyOfRange(arr,i1,j1+1);
        int[] part2 = Arrays.copyOfRange(arr,i2,j2+1);
        int[] part3 = Arrays.copyOfRange(arr,i3,j3+1);


        if(!Arrays.equals(part1,part2) || !Arrays.equals(part1,part3)){
            return new int[]{-1,-1};
        }

        //for trailing zeros
        int first = 0 , second = 0, third = 0;
        first = i2-j1-1;
        second = i3-j2-1;
        third = n-j3-1;

        if(third > Math.min(first,second)){
            return new int[]{-1,-1};
        }

        return new int[]{j1+third,j2+third+1};
    }
}

// TC: O(n)
// SC: O(n)