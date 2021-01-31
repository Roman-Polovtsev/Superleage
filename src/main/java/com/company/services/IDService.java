package com.company.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IDService<T> {
  //  private final Map<Long, T> IDMap;
    private long id_counter;

    public IDService() {
      //  IDMap = new HashMap<>();
        id_counter = 1;
    }

    public IDService(long id){
        id_counter = id;
    }

    public long newObjectID() {
        id_counter++;
     //   IDMap.put(id, object);
        return id_counter-1;
    }

    public long currentID (){
        return id_counter;
    }

//    public void removeObject(long id) {
//        IDMap.remove(id);
//    }

//    public Set<Long> showIDlist() {
//        return IDMap.keySet();
//    }
}
