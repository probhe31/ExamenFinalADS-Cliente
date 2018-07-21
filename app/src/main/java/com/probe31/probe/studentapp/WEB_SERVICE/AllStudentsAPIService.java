package com.probe31.probe.studentapp.WEB_SERVICE;

import com.probe31.probe.studentapp.MODEL.PregradoStudent;
import com.probe31.probe.studentapp.MODEL.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllStudentsAPIService {

    @GET("api/student")
    Call<List<Student>> getAllStudents();

}
