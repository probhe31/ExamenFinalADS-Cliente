package com.probe31.probe.studentapp.WEB_SERVICE;

import com.probe31.probe.studentapp.MODEL.PosgradoStudent;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PosgradoStudentsAPIService {

    @GET("api/posgrado")
    Call<List<PosgradoStudent>> getPosgradoStudents();

}
