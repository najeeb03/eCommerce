package com.example.administrator.ecommerce;

/**
 * Created by Administrator on 9/11/2015.
 */
public class SaleItem {
    String name;
    String price;
    String url;
    int imsgeResId;

    public SaleItem(String name, String price,String url, int imageResId){
        this.name = name;
        this.price = price;
        this.url = url;
        this.imsgeResId = imageResId;
    }
}

