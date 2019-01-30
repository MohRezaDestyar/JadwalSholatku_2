package com.tugasbesar.jadwalsholatku.api;

import com.tugasbesar.jadwalsholatku.model.ModelJadwal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("jember.json")
    Call<ModelJadwal> getJadwal();

}
