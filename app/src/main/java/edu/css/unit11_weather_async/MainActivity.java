package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author      Tom Gibbons
 * @version     (current version number of program)
 * @since       (the version of the package this class was first added to)
 */

public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();


    /**
     * Is the method that initializes the activity.
     * <p>
     *
     * @param  savedInstanceState is the value passed to onCreate that contains the mappings from the given bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }


    /**
     * Is the method that executes what happens when the button is clicked.
     * <p>
     *
     * Will download the weather asynchronously.
     * <p>
     *
     * @param  v is the values passed to btnClick that contains whether or not the button has been clicked.
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
    }


    /**
     * Is the method that sets the new temperature information.
     * <p>
     *
     * @param  newTemp is the values passed to setTemp that contains the new, updated temperature information.
     */
    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }


    /**
     * Is the method that sets the new wind information.
     * <p>
     *
     * @param  newWind is the values passed to setWind that contains the new, updated wind information.
     */
    public void setWind(String newWind) {
        etWind.setText(newWind);
    }


    /**
     * Is the method that gets the new location information.
     * <p>
     *
     * @return returns the current location as a string to the text box.
     */
    public String getLocation() {
        return etLoc.getText().toString();
    }


    /**
     * Is the method that sets the status.
     * <p>
     *
     * @param  newStatus is the values passed to setStatus that contains the status of the application.
     */
    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}
