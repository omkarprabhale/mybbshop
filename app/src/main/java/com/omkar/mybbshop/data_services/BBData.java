package com.omkar.mybbshop.data_services;



import com.google.gson.JsonObject;
import com.omkar.mybbshop.BBSettingsActivity;
import com.omkar.mybbshop.model.BBClient;
import com.omkar.mybbshop.model.BBClientLogin;
import com.omkar.mybbshop.model.BBLoginResp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BBData {


    String BASE_URL = BBSettingsActivity.AppUrl;
    @POST("client/signin")
    Call<BBLoginResp>getLoginDetails(@Body BBClientLogin client);


}
