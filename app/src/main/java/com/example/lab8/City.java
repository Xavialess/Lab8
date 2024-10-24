package com.example.lab8;

import java.util.Objects;

public class City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {City} objects are considered equal if they have the same city and province names.
     *
     * @param o the reference object with which to compare
     * @return {true} if this object is the same as the {@code o} argument; {false} otherwise
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass())
            return false;

        City other = (City) o;
        return Objects.equals(city, other.city) && Objects.equals(province, other.province);


    }
    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by {HashMap}.
     *
     * @return a hash code value for this object based on city and province names
     */
    @Override
    public int hashCode(){
        return Objects.hash(city, province);
    }

}
