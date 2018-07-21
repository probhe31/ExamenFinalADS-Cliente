package com.probe31.probe.studentapp.VIEW;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
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

import com.probe31.probe.studentapp.MODEL.PregradoStudent;
import com.probe31.probe.studentapp.MODEL.Student;
import com.probe31.probe.studentapp.R;
import com.probe31.probe.studentapp.VIEW.ADAPTER.PregradoRecyclerAdapter;
import com.probe31.probe.studentapp.VIEW.ADAPTER.StudentRecyclerAdapter;
import com.probe31.probe.studentapp.VIEW_MODEL.PregradoFragmentViewModel;
import com.probe31.probe.studentapp.VIEW_MODEL.StudentsFragmentViewModel;

import java.util.List;


public class PregradoFragment extends Fragment {

    RecyclerView recyclerView;
    PregradoRecyclerAdapter pregradoRecyclerAdapter;
    PregradoFragmentViewModel pregradoFragmentViewModel;
    List<PregradoStudent> pregradoList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pregrado, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pregradoFragmentViewModel = ViewModelProviders.of(this).get(PregradoFragmentViewModel.class);

        fillRecyclerView();


    }


    void fillRecyclerView()
    {
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_students);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        pregradoRecyclerAdapter = new PregradoRecyclerAdapter(pregradoList);
        recyclerView.setAdapter(pregradoRecyclerAdapter);

        pregradoFragmentViewModel.getPregradoStudents().observe(this, new Observer<List<PregradoStudent>>() {

            @Override
            public void onChanged(@Nullable List<PregradoStudent> pregradoStudents) {

                if(pregradoStudents!=null)
                {
                    pregradoList= pregradoStudents;
                    pregradoRecyclerAdapter.setAccountList(pregradoList);
                }

            }
        });
    }

}
