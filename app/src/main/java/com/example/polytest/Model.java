package com.example.polytest;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    int i;
    String s;

    protected Model(Parcel in) {
        i = in.readInt();
        s = in.readString();
    }

    protected Model(){

    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(i);
        dest.writeString(s);
    }
}
