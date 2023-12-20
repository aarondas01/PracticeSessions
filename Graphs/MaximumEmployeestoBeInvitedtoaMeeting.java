*****Extremely tough question Needs deep understanding of graph. NOT Attempted.*****
class Solution {
    public int maximumInvitations(int[] favorite) {
        // Three possible scenarios
        // First to find the closed pairs a-> b and b-> a. Once found i can expand on both sides of such pairs and all of them can join the table
        // Ex : I might have d -> c -> e -> a -> <- b <- f <- g <- h now this has two ends open which can be used to join with some other similar
        // sequence that could be formed. Thus we can add all such both sides ended lists

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < favorite.length; ++i){
            graph.put(i, new ArrayList<>());
        }

        List<List<Integer>> closed_pairs = new ArrayList<>();
        boolean[] visited = new boolean[favorite.length];

        for(int i =0; i < favorite.length; ++i){
            if(i == favorite[favorite[i]]){
                //these form a pair now and we can avoid duplicates by the below if condition
                if(i < favorite[i]){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(favorite[i]);
                    closed_pairs.add(ls);
                }

            } else{
                //dont form a closed pair so add them to the graph
                //building it in reverse way to make it easier for propagation from any of the pairs
                List<Integer> temp = graph.get(favorite[i]);
                temp.add(i);
                graph.put(favorite[i], temp);
            }
        }

        // now lets try to find the max possible size by combining all the two side open ended possible lists
        int ans = 0;
        for(int i = 0; i < closed_pairs.size(); ++i){
            List<Integer> pair = closed_pairs.get(i);
            ans += dfs(pair.get(0), graph, visited) + dfs(pair.get(1), graph, visited);
        }

        //Now that we are done with both side ended components, we now need to compare it with the second case i.e. the complete circle lists that can be formed from the given graph and get the maximum of such circle lists to compare with this variable ans
        // ex : one possible circular list w->x->y->w. We can only take one of such complete circular lists so we'll find all and take the one with max members
        //In this process we might encounter single ended lists which we have to ignore as we cannot use them as members of our table
        // For example : a -> b -> c- > d-> e-> f-> c  Now in this list we can only use the part from c -> d -> e -> f -> c and ignore the rest which we do in the following

        int[] round = new int[favorite.length];
        int[] counter = new int[favorite.length];

        //this counter is used to set a count for a particular list and find the number of nodes that are a part of the circle in it
        // For Ex : a -> b -> c- > d-> e-> f-> c  if we give counter[a] = 1, b = 2, ... f = 6. As the next is c which is already a part of the list, we can be sure that we encountered a circle and the length of the circle is counter[f] - counter[c] + 1. Hence, this counter array is helpful to track the lenght of the circle

        int r = 1;
        int circle_max =0;

        for(int i = 0; i < favorite.length; ++i){
            if(visited[i]) continue;
            if(round[i] != 0) continue; // it indicates that it is a part of some circle which is already computed

            int count = 1;
            int j = i;
            while(counter[j] == 0){
                counter[j] = count;
                round[j] = r;
                j = favorite[j];
                count++;
            }

            if(round[j] == r){
                //ensuring that we are in the same circle
                int curr = count - counter[j];
                circle_max = Math.max(circle_max, curr);
            }
            r++;
        }

        return Math.max(ans, circle_max);
    }

    public int dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited){
        if(visited[node]) return 0;

        visited[node] = true;

        List<Integer> neigh = graph.get(node);

        int max = 0;
        for(int i =0 ; i < neigh.size(); ++i){
            max = Math.max(max, dfs(neigh.get(i), graph, visited));
        }

        return max + 1;
    }
}

// TC: O(v+e)
// SC: O(v)