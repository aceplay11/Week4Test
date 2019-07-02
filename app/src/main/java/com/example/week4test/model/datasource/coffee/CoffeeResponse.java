
package com.example.week4test.model.datasource.coffee;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoffeeResponse implements Parcelable
{

    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<CoffeeResponse> CREATOR = new Creator<CoffeeResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CoffeeResponse createFromParcel(Parcel in) {
            return new CoffeeResponse(in);
        }

        public CoffeeResponse[] newArray(int size) {
            return (new CoffeeResponse[size]);
        }

    }
    ;

    protected CoffeeResponse(Parcel in) {
        this.desc = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public CoffeeResponse() {
    }

    /**
     * 
     * @param id
     * @param desc
     * @param imageUrl
     * @param name
     */
    public CoffeeResponse(String desc, String imageUrl, String id, String name) {
        super();
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.id = id;
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(desc);
        dest.writeValue(imageUrl);
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
