package com.onestechsolution.gbvjewellers.Utilities;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 5/17/2017.
 */

public class Utilities {

    public Utilities() {
    }

    public static String getStringImage(Bitmap bmp) {
        if(bmp!=null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            Log.i(TAG, "getStringImage: encodedImage: "+encodedImage);
            return encodedImage;
        }
        return null;

    }
}
