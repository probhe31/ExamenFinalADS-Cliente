package com.probe31.probe.studentapp.WEB_SERVICE;

import com.probe31.probe.studentapp.MODEL.DoctoradoStudent;
import com.probe31.probe.studentapp.MODEL.PregradoStudent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DoctoradoAPIService {

    @GET("api/doctorado")
    Call<List<DoctoradoStudent>> getDoctoradoStudents();

}
