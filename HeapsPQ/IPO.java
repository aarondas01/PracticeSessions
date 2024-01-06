class Project {
    int profit;
    int capital;

    Project(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Project [] projects = new Project[profits.length];
        for(int i = 0; i < profits.length; i++){
            projects[i] = new Project(profits[i], capital[i]);
        }

        Arrays.sort(projects, (a,b) -> a.capital - b.capital);
        int counter = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0 ; i < k ; i++){
            while(counter < profits.length && projects[counter].capital <= w){
                pq.add(projects[counter].profit);
                counter++;
            }

            if(pq.size() == 0){
                break;
            }

            w+= pq.poll();
        }

        return w;
    }
}

//TC: O(nlogn)
//SC: O(n)