class UndergroundSystem {
    Map<Integer, ArrivalInfo> arrivals;
    Map<String, double[]> total;

    class ArrivalInfo{
        int id;
        String stationName;
        int time;

        public ArrivalInfo(int id, String stationName, int time){
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }

    public UndergroundSystem() {
        arrivals = new HashMap<>();
        total = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id, new ArrivalInfo(id,stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        ArrivalInfo arrival = arrivals.get(id);
        String key = arrival.stationName +"_" + stationName;
        double[] pair = total.getOrDefault(key, new double[2]);
        int time = t - arrival.time;
        pair[0]+= time;
        pair[1]++;
        total.put(key,pair);

    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "_"+endStation;
        double[] pair = total.get(key);
        return pair[0]/pair[1];
    }
}


//  TC: O(1)
//  SC: O(n)


class Passenger{
    int startTime;
    int endTime;
    String startStation;
    String endStation;

    public Passenger(String startStation, int startTime){
        this.startStation = startStation;
        this.startTime = startTime;
    }

    public void checkout(String endStation, int endTime ){
        this.endStation = endStation;
        this.endTime = endTime;
    }
}

class Route{
    int tripCount;
    long totalTravelTime;


    public Route(){

    }

    public void addTrip(int travelDuration){
        totalTravelTime += travelDuration;
        tripCount +=1;
    }

    public double getAverageTime(){
        return (double)totalTravelTime/tripCount;
    }
}
class UndergroundSystem {

    //PassengerMap <Interger passengerid, Passenger>
    Map<Integer,Passenger> passengerMap;
    //Route Map <String,Route>
    Map<String, Route> routeMap;



    public UndergroundSystem() {
        passengerMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!passengerMap.containsKey(id)){
            Passenger passenger = new Passenger(stationName,t);
            passengerMap.put(id,passenger);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(passengerMap.containsKey(id)){
            Passenger passengerCheckOut = passengerMap.get(id);
            passengerCheckOut.checkout(stationName,t);
            String routeKey = passengerCheckOut.startStation + "_"+ passengerCheckOut.endStation;
            Route routeDetails = routeMap.getOrDefault(routeKey, new Route());
            int duration = passengerCheckOut.endTime - passengerCheckOut.startTime;
            routeDetails.addTrip(duration);
            routeMap.put(routeKey,routeDetails);
            passengerMap.remove(id);

        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "_"+ endStation;
        Route routeDetails = routeMap.get(routeKey);
        return (double)routeDetails.getAverageTime();
    }
}


//  TC: O(1)
//  SC: O(n)