package com.probe31.probe.studentapp.VIEW_MODEL;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.probe31.probe.studentapp.MODEL.PregradoStudent;
import com.probe31.probe.studentapp.MODEL.Student;
import com.probe31.probe.studentapp.REPOSITORY.StudentRepository;

import java.util.List;

public class PregradoFragmentViewModel extends ViewModel{

    private MutableLiveData<List<PregradoStudent>> studentLiveData;
    private StudentRepository studentRepository;

    public PregradoFragmentViewModel(){
        studentLiveData = new MutableLiveData<>();
        studentLiveData.setValue(null);
        studentRepository = new StudentRepository();
    }

    public LiveData<List<PregradoStudent>> getPregradoStudents()
    {
        studentLiveData = studentRepository.getPregradoStudends();
        return studentLiveData;
    }

}
