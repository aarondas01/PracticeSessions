class MyCalendar {

    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //FloorEntry - lower entry value
        //CeilingEntry - high entry value
        //start < lower entry end time
        if(calendar.floorEntry(start) != null && start < calendar.floorEntry(start).getValue()){
            return false;
        }
        if(calendar.ceilingEntry(start) != null && end > calendar.ceilingEntry(start).getKey()){
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

//  TC: O(nlogn)
//  SC: O(1)