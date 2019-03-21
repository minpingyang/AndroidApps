package nz.ac.vuw.ecs.moviewebnews.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yiming on 21/09/17.
 */
public class PictureUtils {
    public static Bitmap getBitmapFromURL(String src){
        //##Missing##
        // Add implementation for this function to obtain a bitmap from the given image url.
        // Hints:
        // 1. Define URL
        // 2. Make HttpURLConnection
        // 3. set connection and InputStream
        // 4. Use BitmapFactory.decodeStream to get the bitmap, then return.
        // 5. After decoding the stream to a bitmap, you can use the following snippet to create a scaled bitmap:
        //    bitmap = Bitmap.createScaledBitmap(bitmap, 2*bitmap.getWidth(), 2*bitmap.getHeight(), false);
        return null;
    }
}
