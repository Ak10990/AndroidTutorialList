package com.android.myandroidtuts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by akanksha on 11/1/17.
 */
public class Topic implements Parcelable {

    private long id;
    private String head;
    private String detail;

    public Topic() {
    }

    public Topic(long id, String head, String detail) {
        this.id = id;
        this.head = head;
        this.detail = detail;
    }

    protected Topic(Parcel in) {
        id = in.readLong();
        head = in.readString();
        detail = in.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(head);
        dest.writeString(detail);
    }

    public static final Creator<Topic> CREATOR = new Creator<Topic>() {
        @Override
        public Topic createFromParcel(Parcel in) {
            return new Topic(in);
        }

        @Override
        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };

}
