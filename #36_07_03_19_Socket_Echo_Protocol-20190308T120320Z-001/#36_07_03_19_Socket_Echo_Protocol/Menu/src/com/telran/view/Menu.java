package com.telran.view;

import java.util.Arrays;
import java.util.List;

public class Menu implements Item {
    private String name;
    private List<Item> items;

    public Menu(String name, Item... items) {
        this.name = name;
        this.items = Arrays.asList(items);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void perform(InputOutput io) {
        while (true){
            display(io);
            int id = io.readInt("Type id",1,items.size());
            Item curr = items.get(id-1);
            if(curr.isExit()){
                break;
            }
            curr.perform(io);
        }
    }

    private void display(InputOutput io){
        io.writeln("-----------------");
        io.writeln(name);
        io.writeln("-----------------");
        int i = 1;
        for(Item item : items){
            io.writeln(String.format( "-%d. %s ",i++,item.name()));
        }
    }
}
