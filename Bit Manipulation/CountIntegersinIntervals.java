class CountIntervals {


    TreeMap<Integer,Integer> map;
    int count = 0;

    public CountIntervals() {
        map = new TreeMap<>();
    }

    public void add(int left, int right) {
        if(map.floorKey(right) != null && map.get(map.floorKey(right)) < left ){
            count += right - left +1;
            map.put(left,right);
        }
        else{
            int start = left, end = right;
            while(map.floorKey(end) != null && map.get(map.floorKey(end)) >= left){
                int l = map.floorKey(end);
                int r = map.get(l);

                count -= r-l+1;
                map.remove(l);

                start = Math.min(start,l);
                end = Math.max(end,r);
            }
            count += end-start +1;
            map.put(start,end);
        }
    }

    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */

//  TC: O(logn)
//  SC: O(n)