package com.example.listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
    }

    @Test
    void testHasCityTrue() {
        CityList list = mockCityList();
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testHasCityFalse() {
        CityList list = mockCityList();
        assertFalse(list.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDeleteRemovesCity() {
        CityList list = mockCityList();

        assertEquals(1, list.countCities());
        list.delete(new City("Edmonton", "Alberta"));
        assertEquals(0, list.countCities());
    }

    @Test
    void testDeleteThrowsException() {
        CityList list = mockCityList();

        assertThrows(IllegalArgumentException.class, () ->
                list.delete(new City("Regina", "Saskatchewan"))
        );
    }

    @Test
    void testCountCities() {
        CityList list = new CityList();

        assertEquals(0, list.countCities());

        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));

        assertEquals(2, list.countCities());
    }
}