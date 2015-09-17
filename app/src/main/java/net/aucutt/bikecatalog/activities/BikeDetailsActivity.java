package net.aucutt.bikecatalog.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.aucutt.bikecatalog.data.BikeConstants;
import net.aucutt.bikecatalog.data.BikeInfoObject;
import net.aucutt.bikecatalog.R;

/**
 * Activity to display the details of selected bike and allows a user to select the add to cart.
 * In the case of description, the data is looked up.
 */
public class BikeDetailsActivity extends Activity {

    BikeInfoObject selectedBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent startingIntent = getIntent();
        selectedBike = startingIntent.getParcelableExtra(BikeConstants.SELECTED_BIKE);
        lookupDescription();
        setTitle(selectedBike.getModelName() );
        setContentView(R.layout.activity_bike_details);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView titleView = (TextView) findViewById( R.id.detailslabel);
        titleView.setText(selectedBike.getBrandName() + " " + selectedBike.getModelName() + " "
                + selectedBike.getPrice());
        ImageView bikeImage = (ImageView) findViewById(R.id.detailsimage);
        bikeImage.setImageResource(selectedBike.getResourceId());
        TextView detailText =  (TextView) findViewById(R.id.detailstext);
        detailText.setText(selectedBike.getDescription());
    }

    /**
     * Rather than have each bike in the list hold what could be a lengthy description, we only
     * look up the description once a bike is selected.
     */
    private void lookupDescription( ){
        //@TODO -  Actually lookup description.
        selectedBike.setDescription(BikeConstants.CANNED_DESCRIPTION);

    }

    /**
     * Too many people were buying multiple bikes on accident.
     * @param view - Button that was selected.
     */
    public void  onAddToCart( View view){
        Button clickedButton = (Button)view;
        clickedButton.setClickable( false);
        clickedButton.setEnabled( false );
    }
}
