package com.example.bienesraicesgye;

import android.graphics.Bitmap;
import java.io.Serializable;

public class Departamento implements Serializable {

    private String name;
    private String price;
    private Bitmap image;

    public Departamento(String name, String price, Bitmap image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Bitmap getImage() {
        return image;
    }
}
