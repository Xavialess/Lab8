package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my cityList
     * @return the list
     */
    public CustomList mockCityList(){
        list  = new CustomList(null, new ArrayList<>());
        return list;
    };



    @Test
    void testAddCity(){

        list = mockCityList();
        int list_size = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), list_size+1);

    }

    @Test
    void testHasCity(){
        list = mockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));

    }

    @Test
    void testDelete(){
        list = mockCityList();
        City nCity = new City("Calgary", "Alberta");
        // adding a new city
        list.addCity(nCity);
        // checks if the new city was added
        assertTrue(list.hasCity(nCity));
        // delete the city
        list.delete(nCity);
        // check the city is not present anymore
        assertFalse(list.hasCity(nCity));
        // checks that it is not possible to delete a city that does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(nCity);
        });
    }

    @Test
    void testCountCities(){
        list = mockCityList();
        // add a new city
        list.addCity(new City("Vanocuver", "BC"));
        // count should be 2
        assertEquals(1, list.countCities());
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(2, list.countCities());

    }


}
