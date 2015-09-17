package net.aucutt.bikecatalog.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import net.aucutt.bikecatalog.R;
import java.util.List;

/**
 * Extension of ArrayAdapter to populate a listView of bikes.
 *
 * Created by darrellaucutt on 9/15/15.
 */
public class BikeListArrayAdapter extends ArrayAdapter<BikeInfoObject> {

    private final Context context;
    private final List<BikeInfoObject> values;
    private int resourceid;

    public BikeListArrayAdapter(Context context, int resource, List<BikeInfoObject> objects) {
        super( context, resource, objects);
        this.context = context;
        this.values = objects;
        resourceid = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resourceid, parent, false);
        TextView brand =  (TextView) rowView.findViewById(R.id.brandname);
        TextView model =  (TextView) rowView.findViewById(R.id.modelname);
        TextView price =  (TextView) rowView.findViewById(R.id.price);
        ImageView url =  (ImageView) rowView.findViewById(R.id.image);
        brand.setText(values.get(position).getBrandName());
        model.setText( values.get( position).getModelName() );
        price.setText( values.get( position).getPrice() );
        url.setImageResource( values.get( position).getResourceId() );
        return rowView;
    }
}
