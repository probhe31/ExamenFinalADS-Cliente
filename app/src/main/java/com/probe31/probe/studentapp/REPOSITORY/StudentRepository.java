package com.probe31.probe.studentapp.REPOSITORY;

import android.arch.lifecycle.MutableLiveData;

import com.probe31.probe.studentapp.MODEL.DoctoradoStudent;
import com.probe31.probe.studentapp.MODEL.PosgradoStudent;
import com.probe31.probe.studentapp.MODEL.PregradoStudent;
import com.probe31.probe.studentapp.MODEL.Student;
import com.probe31.probe.studentapp.WEB_SERVICE.AllStudentsAPIService;
import com.probe31.probe.studentapp.WEB_SERVICE.DoctoradoAPIService;
import com.probe31.probe.studentapp.WEB_SERVICE.PosgradoStudentsAPIService;
import com.probe31.probe.studentapp.WEB_SERVICE.PregradoStudentsAPIService;
import com.probe31.probe.studentapp.WEB_SERVICE.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentRepository {

    private AllStudentsAPIService allStudentsAPIService;
    private PregradoStudentsAPIService pregradoStudentsAPIService;
    private PosgradoStudentsAPIService posgradoStudentsAPIService;
    private DoctoradoAPIService doctoradoAPIService;

    public MutableLiveData<List<PregradoStudent>> getPregradoStudends(){

        final MutableLiveData<List<PregradoStudent>> pregradoResponseLiveData = new MutableLiveData<>();
        pregradoStudentsAPIService =  RetrofitClientInstance.getRetrofitInstance().create(PregradoStudentsAPIService.class);

        Call<List<PregradoStudent>> call = pregradoStudentsAPIService.getPregradoStudents();
        call.enqueue(new Callback<List<PregradoStudent>>() {
            @Override
            public void onResponse(Call<List<PregradoStudent>> call, Response<List<PregradoStudent>> response) {

                List<PregradoStudent> pregradoStudents = response.body();

                if(pregradoStudents!=null){
                    pregradoResponseLiveData.setValue(pregradoStudents);
                }else {
                    pregradoResponseLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<PregradoStudent>> call, Throwable t) {
                pregradoResponseLiveData.setValue(null);

            }
        });

        return pregradoResponseLiveData;

    }


    public MutableLiveData<List<PosgradoStudent>> getPosgradoStudends(){

        final MutableLiveData<List<PosgradoStudent>> posgradoResponseLiveData = new MutableLiveData<>();
        posgradoStudentsAPIService =  RetrofitClientInstance.getRetrofitInstance().create(PosgradoStudentsAPIService.class);

        Call<List<PosgradoStudent>> call = posgradoStudentsAPIService.getPosgradoStudents();
        call.enqueue(new Callback<List<PosgradoStudent>>() {
            @Override
            public void onResponse(Call<List<PosgradoStudent>> call, Response<List<PosgradoStudent>> response) {

                List<PosgradoStudent> posgradoStudents = response.body();

                if(posgradoStudents!=null){
                    posgradoResponseLiveData.setValue(posgradoStudents);
                }else {
                    posgradoResponseLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<PosgradoStudent>> call, Throwable t) {
                posgradoResponseLiveData.setValue(null);

            }
        });

        return posgradoResponseLiveData;

    }


    public MutableLiveData<List<DoctoradoStudent>> getDoctoradoStudends(){

        final MutableLiveData<List<DoctoradoStudent>> doctoradoResponseLiveData = new MutableLiveData<>();
        doctoradoAPIService =  RetrofitClientInstance.getRetrofitInstance().create(DoctoradoAPIService.class);

        Call<List<DoctoradoStudent>> call = doctoradoAPIService.getDoctoradoStudents();
        call.enqueue(new Callback<List<DoctoradoStudent>>() {
            @Override
            public void onResponse(Call<List<DoctoradoStudent>> call, Response<List<DoctoradoStudent>> response) {

                List<DoctoradoStudent> doctoradoStudents = response.body();

                if(doctoradoStudents!=null){
                    doctoradoResponseLiveData.setValue(doctoradoStudents);
                }else {
                    doctoradoResponseLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<DoctoradoStudent>> call, Throwable t) {
                doctoradoResponseLiveData.setValue(null);

            }
        });

        return doctoradoResponseLiveData;
    }


    public MutableLiveData<List<Student>> getAllStudents(){

        final MutableLiveData<List<Student>> studentsResponseLiveData = new MutableLiveData<>();
        allStudentsAPIService =  RetrofitClientInstance.getRetrofitInstance().create(AllStudentsAPIService.class);

        Call<List<Student>> call = allStudentsAPIService.getAllStudents();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                List<Student> students = response.body();

                if(students!=null){
                    studentsResponseLiveData.setValue(students);
                }else {
                    studentsResponseLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                studentsResponseLiveData.setValue(null);

            }
        });

        return studentsResponseLiveData;
    }
}
