class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {

        // Bottom up dp - for each lap i, see if we get optimal time by changing tires  in       lap j before it ie dp[i] = Math.min (dp[i], dp[j] + changeTime + dp[i - j])
        //Min time to finish all laps without changing tires compared across all tires
        int[] minTimes = new int[numLaps+1];
        Arrays.fill(minTimes,Integer.MAX_VALUE);

        for(int[] tire : tires){
            populateMinTime(minTimes,tire,changeTime,numLaps);
        }

        //for every lap i , check if you get better time by changing tires
        // on all laps before i, (from 1 to i) using the j loop

        for(int i=1; i <= numLaps; i++){
            for(int j =1 ; j < i ; j++){
                minTimes[i] = Math.min(minTimes[i], minTimes[j] + changeTime + minTimes[i-j]);
            }
        }

        return minTimes[numLaps];

    }

    public void populateMinTime(int[] minTimes, int[] tire, int changeTime, int numLaps){
        int baseTime = tire[0];
        int expTime = tire[1];

        //to keep track of a lap time and entire race time using this tire
        int lapTime = baseTime;
        int totalTime = lapTime;

        minTimes[1] = Math.min(baseTime, minTimes[1]);
        for(int lap=2; lap <= numLaps; lap++){
            lapTime *= expTime;

            if(lapTime > changeTime + baseTime){
                break;
            }
            totalTime += lapTime;

            minTimes[lap] = Math.min(minTimes[lap],totalTime);
        }

    }
}

// TC: O(n)
// SC: O(N)