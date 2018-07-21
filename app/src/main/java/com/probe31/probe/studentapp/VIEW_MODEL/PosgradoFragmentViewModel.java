package com.probe31.probe.studentapp.VIEW_MODEL;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.probe31.probe.studentapp.MODEL.PosgradoStudent;
import com.probe31.probe.studentapp.REPOSITORY.StudentRepository;
import java.util.List;

public class PosgradoFragmentViewModel extends ViewModel {

    private MutableLiveData<List<PosgradoStudent>> studentLiveData;
    private StudentRepository studentRepository;

    public PosgradoFragmentViewModel(){
        studentLiveData = new MutableLiveData<>();
        studentLiveData.setValue(null);
        studentRepository = new StudentRepository();
    }

    public LiveData<List<PosgradoStudent>> getPosgradoStudents()
    {
        studentLiveData = studentRepository.getPosgradoStudends();
        return studentLiveData;
    }

}
