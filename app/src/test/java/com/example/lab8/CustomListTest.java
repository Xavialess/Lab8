package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
        list.addCity(new City("Edmonton", "AB"));
        assertTrue(list.hasCity("Edmonton"));

    }


}
