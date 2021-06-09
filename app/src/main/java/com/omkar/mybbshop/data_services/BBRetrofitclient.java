package com.omkar.mybbshop.data_services;

import androidx.appcompat.widget.AppCompatImageHelper;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BBRetrofitclient {

        private static BBRetrofitclient instance = null;
        private BBData myApi;

        private BBRetrofitclient() {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BBData.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(BBData.class);
        }

        public static synchronized BBRetrofitclient getInstance() {
            if (instance == null) {
                instance = new BBRetrofitclient();
            }
            return instance;
        }

        public BBData getMyApi() {
            return myApi;
        }

}
