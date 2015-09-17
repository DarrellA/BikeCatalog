package net.aucutt.bikecatalog.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import net.aucutt.bikecatalog.data.BikeConstants;
import net.aucutt.bikecatalog.data.BikeInfoObject;
import net.aucutt.bikecatalog.data.BikeListArrayAdapter;
import net.aucutt.bikecatalog.R;
import java.util.ArrayList;

/**
 * Extension of ListActivity that displays BikeInfoObjects
 */
public class BikeListActivity extends ListActivity {

    private ArrayList<BikeInfoObject> bikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bikes = getBikesFromDB( 12 );
        BikeListArrayAdapter bikeAdapter = new BikeListArrayAdapter( this, R.layout.listitemlayout, bikes);
        ListView listView = getListView();
        listView.setAdapter(bikeAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        BikeInfoObject selectedBike = bikes.get( position);
        Intent detailsIntent = new Intent(this, BikeDetailsActivity.class);
        detailsIntent.putExtra( BikeConstants.SELECTED_BIKE, selectedBike);
        startActivity( detailsIntent );
    }

    /**
     * Dummy method to create an ArrayList of bikes.  Should be replaced by something either pulling from the web
     * or a database.   Of course if we are pulling from the web we might  use a handler or asyntask.
     * Pulling from the db, we should use a loader.
     *
     * @param sizeOfDummyData - how much dummy data would you like?
     * @return  the bikes to displayed
     */


    protected ArrayList<BikeInfoObject> getBikesFromDB( int sizeOfDummyData){
        ArrayList<BikeInfoObject> mockedbikes = new ArrayList<BikeInfoObject>(sizeOfDummyData);
        //@TODO get the bikes from real persistent storage or maybe the internet
        BikeInfoObject trekBike = new BikeInfoObject("Trek","CrossRip Elite","$1,199.99",R.drawable.treksmall);
        BikeInfoObject khsBike = new BikeInfoObject("KHS","Flite 700","$1,649.00",R.drawable.khssmall);
        for( int i = 0; i < sizeOfDummyData; i++){
            if( (i % 2) == 0 ){
                mockedbikes.add(trekBike);
            }else {
                mockedbikes.add(khsBike);
            }
        }
        return mockedbikes;
    }

}
