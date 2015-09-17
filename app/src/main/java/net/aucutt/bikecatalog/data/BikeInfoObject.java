package net.aucutt.bikecatalog.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Holds the data associated with a bike.  Implements parcelable to be passed with intents.
 * Created by darrellaucutt on 9/15/15.
 */
public class BikeInfoObject implements Parcelable {
    private String brandName;
    private String modelName;
    private String price;
    private Integer resourceId;
    private String descripton;  //currently not part of the parcelable as we don't pass it with intents.
    private static final String KEY_BRAND = "brand";
    private static final String KEY_MODEL= "model";
    private static final String KEY_PRICE = "price";
    private static final String KEY_RESOURCE_ID = "url";

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getPrice() {
        return price;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setDescription( String description){
        this.descripton = description;
    }

    public String getDescription(){
        return descripton;
    }

    public BikeInfoObject(String brandName, String modelName, String price, Integer resourceId){
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.resourceId = resourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putString( KEY_BRAND, brandName);
        bundle.putString( KEY_MODEL, modelName);
        bundle.putString( KEY_PRICE, price );
        bundle.putInt(KEY_RESOURCE_ID, resourceId);
        dest.writeBundle(bundle);
    }

    public static final Parcelable.Creator<BikeInfoObject> CREATOR = new Creator<BikeInfoObject>() {
        @Override
        public BikeInfoObject createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();
            return new BikeInfoObject( bundle.getString( KEY_BRAND), bundle.getString( KEY_MODEL), bundle.getString( KEY_PRICE), bundle.getInt(KEY_RESOURCE_ID));
        }

        @Override
        public BikeInfoObject[] newArray(int size) {
            return new BikeInfoObject[size];
        }
    };

    @Override
    public String toString() {
        return "BikeInfoObject{" +
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", price='" + price + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
