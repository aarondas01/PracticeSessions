class Job {
    public int startTime, endTime, profit;
    Job(int startTime, int endTime, int profit){
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
class Solution {
    int[] table;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //top down DP Memoization
        int n = startTime.length;

        table = new int[n];

        Arrays.fill(table,-1);

        Job[] jobs = new Job[n];

        for(int i = 0 ; i < n ; i++){
            jobs[i]  = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (j1,j2)-> {
            return Integer.compare(j1.startTime,j2.startTime);
        });

        return helper(jobs, 0, n);
    }

    private int helper(Job[] jobs, int index, int n){
        if(index >= n){
            return 0;
        }

        if(table[index] != -1){
            return table[index];
        }
        int include = jobs[index].profit;

        int nextJob = findIndexOfNonConflictingJob(jobs,index,n);

        if(nextJob != -1){
            include += helper(jobs,nextJob,n);
        }
        int exclude = helper(jobs, index+1,n);


        return table[index] = Math.max(include, exclude);
    }

    ////use binary search to sort array

    private int findIndexOfNonConflictingJob(Job[] jobs, int index, int n){
        int startTime = index+1, endTime = n-1, ans =-1;

        while(startTime <= endTime){
            int mid = startTime + (endTime-startTime) /2;
            if(jobs[index].endTime <= jobs[mid].startTime){
                ans = mid ;
                endTime = mid-1;
            }
            else{
                startTime = mid+1;
            }
        }
        return ans;
    }
}

// TC: O(nlogn)
// SC: O(n)

