package com.fastlane.helper.util;

import com.fastlane.helper.models.ScreenDimension;
import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

/**
 * Created by nishantgupta on 4/5/15.
 */
public class InventoryImageSelector {

    private static Gson gson = new Gson();
    @Data
    public class ProductSDImage{
        private int length;
        private int height;
        private String image;
    }

    //NO logic has been implemented to change the images as per screen size
    public static String getImageUrl(ScreenDimension screenDimension, String imageJson){
        List<ProductSDImage> sdImages =  gson.fromJson(imageJson, List.class);
        return sdImages.get(0).getImage();
    }

}
