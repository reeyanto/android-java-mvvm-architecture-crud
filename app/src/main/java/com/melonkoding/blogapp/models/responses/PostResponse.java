package com.melonkoding.blogapp.models.responses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class PostResponse implements Parcelable {

    private int id;
    private String title, description;

    @SerializedName("created_at")
    private String createdAt;

    public PostResponse(int id, String title, String description, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    protected PostResponse(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        createdAt = in.readString();
    }

    public static final Creator<PostResponse> CREATOR = new Creator<PostResponse>() {
        @Override
        public PostResponse createFromParcel(Parcel in) {
            return new PostResponse(in);
        }

        @Override
        public PostResponse[] newArray(int size) {
            return new PostResponse[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(createdAt);
    }
}
