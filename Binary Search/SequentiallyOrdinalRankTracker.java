class SORTracker {

//sort the locations  based on score
//location with higher score is valued more than lower score
//if scores are same, sort basis of lexicographical order

    //store the rank tracker in a map
// <key,value> <score, <list of locations in sorted order>>
    private TreeMap<Integer, List<String>> treemap;
    private int queryCount = 0;
    public SORTracker() {
        //descending sorted order
        treemap = new TreeMap<>((a,b)-> (b-a));
    }

    public void add(String name, int score) {
        treemap.putIfAbsent(score, new ArrayList<>());
        List<String> locationList = treemap.get(score);

        if (locationList.size() == 0) locationList.add(name);
        else {
            //find the index (lexicographical order) where the new location should be inserted
            int idx = findPosition(locationList, name);
            locationList.add(idx, name);
        }
        treemap.put(score, locationList);
    }


    public String get() {
        int searchIndex = queryCount;
        String res = "";
        for (int score : treemap.keySet()) {
            if (searchIndex < treemap.get(score).size()) {
                res = treemap.get(score).get(searchIndex);
                break;
            } else searchIndex -= treemap.get(score).size();
        }
        this.queryCount++;
        return res;
    }

    private int findPosition(List<String> locationList, String str){
        int left = 0 , right = locationList.size()-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(locationList.get(mid).compareTo(str) <0){
                left = mid+1;
            }
            else{
                right = mid;
            }

        }
        return locationList.get(left).compareTo(str) >= 0 ? left : left+1;
    }
}


//TC: O(nlogn)
//SC: O(n)