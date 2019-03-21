package nz.ac.vuw.ecs.moviewebnews;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import nz.ac.vuw.ecs.moviewebnews.utils.ECSAuthenticator;
import nz.ac.vuw.ecs.moviewebnews.utils.PictureUtils;

public class MainActivity extends AppCompatActivity {


    private static final String URL = "http://movieweb.com/rss/all-news/";

    private Image image = null;

    private Bitmap bitmap = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainTask().execute();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setup the Proxy for using the internet access from workstations at school
        java.net.Authenticator.setDefault(new ECSAuthenticator());
        System.setProperty("http.proxyHost", "www-cache.ecs.vuw.ac.nz");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("http.nonProxyHosts", "localhost|*.vuw.ac.nz|*.victoria.ac.nz|*.elvis.ac.nz");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    /**
     * This method is to reset the display on screen after
     * retrieving the latest image from RSS.
     *
     * @param
     * @return Nothing.
     */

    public void resetDisplay() {
        //##Missing##
        //Update the text content of the TextView widget "imageTitle"


        //##Missing##
        //Update the text content of the TextView widget "imageDate"


        //##Missing##
        //Update the text content of the TextView widget "imageDescription"

        ////##Missing##
        //Update the image of the ImageView widget "imageView" with bitmap
        //Update the text content of the TextView widget "imageTitle"
    }
    /**
     * This inner class inherits from AsyncTask which performs background
     * operations and publish results on the UI thread.
     */
    public class MainTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... params) {
            //##Missing##
            //Invoke the function to retrieve the latest news from Movie Web RSS feed.
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            //##Missing##
            //Invoke the function to reset display after the latest daily news is obtained.
        }

        /**
         * This method is used to retrieve the latest daily image from MovieWeb RSS feed.
         * @param
         * @return Nothing.
         */
        public void processFeed() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                SAXParserFactory saxParserFactory =
                        SAXParserFactory.newInstance();
                SAXParser parser = saxParserFactory.newSAXParser();
                XMLReader reader = parser.getXMLReader();
                IotdHandler iotdHandler = new IotdHandler();
                reader.setContentHandler(iotdHandler);

                InputStream inputStream = new URL(URL).openStream();
                reader.parse(new InputSource(inputStream));
                image = iotdHandler.getImage();
                bitmap = PictureUtils.getBitmapFromURL(image.getUrl());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
