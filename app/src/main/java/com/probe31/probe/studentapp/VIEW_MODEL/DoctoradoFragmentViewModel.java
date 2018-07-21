package com.probe31.probe.studentapp.VIEW_MODEL;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.probe31.probe.studentapp.MODEL.DoctoradoStudent;
import com.probe31.probe.studentapp.REPOSITORY.StudentRepository;

import java.util.List;

public class DoctoradoFragmentViewModel extends ViewModel {

    private MutableLiveData<List<DoctoradoStudent>> studentLiveData;
    private StudentRepository studentRepository;

    public DoctoradoFragmentViewModel(){
        studentLiveData = new MutableLiveData<>();
        studentLiveData.setValue(null);
        studentRepository = new StudentRepository();
    }

    public LiveData<List<DoctoradoStudent>> getDoctoradoStudends()
    {
        studentLiveData = studentRepository.getDoctoradoStudends();
        return studentLiveData;
    }

}
