package com.telran;

import com.telran.data.entity.CityEntity;
import com.telran.data.managers.CatalogManager;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        CatalogManager manager =
                new CatalogManager("db","cat.csv","cities.csv");
        manager.addCity(CityEntity.of("Ashdod"));
        manager.addCity(CityEntity.of("Haifa"));
    }
}
