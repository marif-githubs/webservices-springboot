package com.TODO.S.webservices.Service;

import com.TODO.S.webservices.TODOitem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class Services {

    ArrayList<TODOitem> list = new ArrayList<>();

    public Services(){
        list.add(new TODOitem("12","buy milk","12/04/2025"));
        list.add(new TODOitem("13","buy meat","12/04/2025"));
        list.add(new TODOitem("14","buy bread","12/04/2025"));
    }

    public ArrayList<TODOitem> getList() {
        return list;
    }

    public TODOitem appendList(TODOitem item) {

        if(item.gettodo() == null || item.getdeadline() == null){
            System.out.println("null");
            return null;
        }

        item.setId(getRandomId());
        list.add(item);
        return item;
    }

    public String deleteFromList(String id){
        TODOitem item = null;

        for (TODOitem temp : list) {
            if (temp.getId().equals(id)) {
                item = temp;
                break;
            }
        }

        boolean remove = list.remove(item);
        if(remove){
            return id.toString();
        }

        return "error occurs";
    }

    private void show() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println(i);
        }
    }

    public String getRandomId() {
        return UUID.randomUUID().toString();
    }

}
