package com.company;

public class Main {

    public static void main(String[] args) {

        private Set<Address> addrList = new HashSet<Address>();
        private Map<Hall,Address> hallAddrMap = new HashMap<Hall, Address>();
        private Map<Team, Hall> teamHallMap = new HashMap<Team, Hall>();
        private Map<Schedule, Result> scheduleResultMap = new HashMap<Schedule, Result>();
        private Set<Result> resultList = new HashSet<Result>(); 

        public void addAddr ( Address newAddr){
            addrList.add(newAddr);
        };

        public void addHallAddr ( Hall hall, Address addr){
            hallAddrMap.put(hall,addr);
        };

        public Address getHallAddr ( Hall hall){
            return hallAddrMap.get(hall);
        };

        public void addTeamHall ( Team team, Hall hall){
            teamHallMap.put(team,hall);
        };

        public Hall getTeamHall ( Team team){
            return teamHallMap.get(team);
        };

        public void addScheduleResultMap (Schedule schedule, Result result){
            scheduleResultMap.put(schedule, result);
        }

        public Result getScheduleResultMap (Schedule schedule){
            scheduleResultMap.get(schedule);
        }

        public Result getScheduleResultMap (Schedule schedule){
            scheduleResultMap.get(schedule);
        }

        public void addResult (Result result){
            resultList.add(result);
        }

        public Result getResult (Result result){
            resultList.get(result);
        }



        Address addr1 = new Address("spb","petrovsky","27");
        Address addr2 = new Address("spb","nevsky","135 C");

        Hall hall1 = new Hall ( addr1 );
        Hall hall2 = new Hall ( addr2 );

        Team lmgt = new Team("lmgt", hall1 );
        Team lenenergo = new Team("lenenergo", hall2);

        Schedule lmgtLenenergo = new Schedule ( lmgt, lenenergo );

        Result lmgtLenenergoRes = new Result ( 3,0,lmgt, lenenergo ); 

        Schedule.getResult(lmgtLenenergo);
        System.out.println(item);

        

        
        // Team.show();
        // Hall hall1 = new Hall();
        // hall1.getAddressSet()
//        public void addHall (String street, String city, String building){
//            Hall hall = new Hall();
//            hall.setAddress().;
//        }
//        //adding Classes
//        Schedule schedule = new Schedule();
    }
}

