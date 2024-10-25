package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private ArrayList<City> cityList = new ArrayList<>();

    @Test
    public void testAddCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(1, list.getCount());
    }

    @Test
    public void testHasCity() {
        CustomList list = new CustomList(null, cityList);
        City firstCity = new City("Kelowna", "BC");
        list.addCity(firstCity);
        assertTrue(list.hasCity(firstCity));
        City secondCity=new City("Vancouver", "BC");
        assertFalse(list.hasCity(secondCity));
    }

    @Test
    public void testDeleteCity() {
        CustomList list=new CustomList(null, cityList);
        City newCity=new City("Toronto", "ON");
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
        list.deleteCity(newCity);
        assertFalse(list.hasCity(newCity));
        assertThrows(IllegalArgumentException.class, ()->{
            list.deleteCity(new City("Montreal", "QC"));
        });
    }

    @Test
    public void testCountCities() {
        CustomList list=new CustomList(null, cityList);
        assertEquals(0, list.countCities());
        City firstCity=new City("Ottawa", "ON");
        list.addCity(firstCity);
        assertEquals(1, list.countCities());
        City secondCity=new City("Halifax", "NS");
        list.addCity(secondCity);
        assertEquals(2, list.countCities());
        list.deleteCity(firstCity);
        assertEquals(1, list.countCities());
    }
}
