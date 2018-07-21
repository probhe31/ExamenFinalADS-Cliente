package com.probe31.probe.studentapp.WEB_SERVICE;

import com.probe31.probe.studentapp.MODEL.PregradoStudent;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PregradoStudentsAPIService {

    @GET("api/pregrado")
    Call<List<PregradoStudent>> getPregradoStudents();
}
