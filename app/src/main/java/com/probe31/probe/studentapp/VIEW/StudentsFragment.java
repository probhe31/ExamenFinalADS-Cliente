package com.probe31.probe.studentapp.VIEW;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.probe31.probe.studentapp.MODEL.Student;
import com.probe31.probe.studentapp.R;
import com.probe31.probe.studentapp.VIEW.ADAPTER.StudentRecyclerAdapter;
import com.probe31.probe.studentapp.VIEW_MODEL.StudentsFragmentViewModel;

import java.util.List;


public class StudentsFragment extends Fragment {


    RecyclerView recyclerView;
    StudentRecyclerAdapter studentRecyclerAdapter;
    StudentsFragmentViewModel studentsFragmentViewModel;
    List<Student> studentList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_students, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        studentsFragmentViewModel = ViewModelProviders.of(this).get(StudentsFragmentViewModel.class);

        fillRecyclerView();


    }


    void fillRecyclerView()
    {
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_students);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        studentRecyclerAdapter = new StudentRecyclerAdapter(studentList);
        recyclerView.setAdapter(studentRecyclerAdapter);

        studentsFragmentViewModel.getAllStudents().observe(this, new Observer<List<Student>>() {

            @Override
            public void onChanged(@Nullable List<Student> students) {

                if(students!=null)
                {
                    studentList= students;
                    studentRecyclerAdapter.setAccountList(studentList);
                }

            }
        });
    }

}
