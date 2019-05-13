package com.example.remindme;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonAPI {

    @GET("events")
    Call<List<EventElement>> GetEvents();
}
