package com.telran;

import com.telran.controllers.UserController;
import com.telran.controllers.UserControllerImpl;
import com.telran.data.entity.CityEntity;
import com.telran.data.managers.CatalogManager;
import com.telran.data.managers.UserManager;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        UserController userController = new UserControllerImpl(
                new UserManager("db","users.csv","profiles.csv"));
        CatalogManager manager =
                new CatalogManager("db","cat.csv","cities.csv");
        manager.addCity(CityEntity.of("Ashdod"));
        manager.addCity(CityEntity.of("Haifa"));
    }
}
