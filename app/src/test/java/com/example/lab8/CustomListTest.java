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
        CustomList cityList = mockCityList();
        City nCity = new City("Calgary", "Alberta");
        // adding a new city
        cityList.addCity(nCity);
        // checks if the new city was added
        assertTrue(cityList.hasCity(nCity));
        // delete the city
        cityList.delete(nCity);
        // check the city is not present anymore
        assertFalse(cityList.hasCity(nCity));
        // checks that it is not possible to delete a city that does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(nCity);
        });
    }


}
