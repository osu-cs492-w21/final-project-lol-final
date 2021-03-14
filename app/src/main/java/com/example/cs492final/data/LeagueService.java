package com.example.cs492final.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LeagueService {
    @GET("versions.json")
    Call<Versions> fetchVersions(
//            @Query("api_key") String apiKey
    );
}
