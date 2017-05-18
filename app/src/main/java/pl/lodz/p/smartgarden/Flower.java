package pl.lodz.p.smartgarden;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jusia on 16.05.2017.
 */
public abstract class Flower implements Parcelable {
    protected int lightValue, waterValue;
    protected String name;

    public Flower() {

    }

    public int getLightValue() {
        return lightValue;
    }

    public int getWaterValue() {
        return waterValue;
    }

    public String getName() {
        return this.name;
    }

    protected Flower(Parcel in) {
        lightValue = in.readInt();
        waterValue = in.readInt();
        name = in.readString();
    }

    //@Override
   // public int describeContents() {
  //      return 0;
  //  }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(lightValue);
        dest.writeInt(waterValue);
        dest.writeString(name);
    }

    /*@SuppressWarnings("unused")
    public static final Parcelable.Creator<Flower> CREATOR = new Parcelable.Creator<Flower>() {
        @Override
        public Flower createFromParcel(Parcel in) {
            return new Flower(in);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    }; */

}
