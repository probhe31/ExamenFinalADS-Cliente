package com.probe31.probe.studentapp.VIEW_MODEL;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.probe31.probe.studentapp.MODEL.Student;
import com.probe31.probe.studentapp.REPOSITORY.StudentRepository;

import java.util.List;


public class StudentsFragmentViewModel extends ViewModel {

    private MutableLiveData<List<Student>> studentLiveData;
    private StudentRepository studentRepository;

    public StudentsFragmentViewModel(){
        studentLiveData = new MutableLiveData<>();
        studentLiveData.setValue(null);
        studentRepository = new StudentRepository();
    }

    public LiveData<List<Student>> getAllStudents()
    {
        studentLiveData = studentRepository.getAllStudents();
        return studentLiveData;
    }

}
