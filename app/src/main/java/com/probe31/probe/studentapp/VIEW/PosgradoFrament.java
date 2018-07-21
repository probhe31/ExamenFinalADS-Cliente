package com.probe31.probe.studentapp.VIEW;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.probe31.probe.studentapp.MODEL.PosgradoStudent;
import com.probe31.probe.studentapp.MODEL.PregradoStudent;
import com.probe31.probe.studentapp.R;
import com.probe31.probe.studentapp.VIEW.ADAPTER.PosgradoRecyclerAdapter;
import com.probe31.probe.studentapp.VIEW.ADAPTER.PregradoRecyclerAdapter;
import com.probe31.probe.studentapp.VIEW_MODEL.PosgradoFragmentViewModel;
import com.probe31.probe.studentapp.VIEW_MODEL.PregradoFragmentViewModel;

import java.util.List;


public class PosgradoFrament extends Fragment {

    RecyclerView recyclerView;
    PosgradoRecyclerAdapter posgradoRecyclerAdapter;
    PosgradoFragmentViewModel posgradoFragmentViewModel;
    List<PosgradoStudent> posgradoList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_posgrado, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        posgradoFragmentViewModel = ViewModelProviders.of(this).get(PosgradoFragmentViewModel.class);

        fillRecyclerView();


    }


    void fillRecyclerView()
    {
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_students);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        posgradoRecyclerAdapter = new PosgradoRecyclerAdapter(posgradoList);
        recyclerView.setAdapter(posgradoRecyclerAdapter);

        posgradoFragmentViewModel.getPosgradoStudents().observe(this, new Observer<List<PosgradoStudent>>() {

            @Override
            public void onChanged(@Nullable List<PosgradoStudent> posgradoStudents) {

                if(posgradoStudents!=null)
                {
                    posgradoList= posgradoStudents;
                    posgradoRecyclerAdapter.setAccountList(posgradoList);
                }

            }
        });
    }
}
