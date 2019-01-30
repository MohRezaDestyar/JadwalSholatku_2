package com.tugasbesar.jadwalsholatku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


//memanggil class Item
public class ModelJadwal {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
