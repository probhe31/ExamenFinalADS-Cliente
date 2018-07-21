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

import com.probe31.probe.studentapp.MODEL.DoctoradoStudent;
import com.probe31.probe.studentapp.MODEL.PosgradoStudent;
import com.probe31.probe.studentapp.R;
import com.probe31.probe.studentapp.VIEW.ADAPTER.DoctoradoRecyclerAdapter;
import com.probe31.probe.studentapp.VIEW.ADAPTER.PosgradoRecyclerAdapter;
import com.probe31.probe.studentapp.VIEW_MODEL.DoctoradoFragmentViewModel;
import com.probe31.probe.studentapp.VIEW_MODEL.PosgradoFragmentViewModel;

import java.util.List;


public class DoctoradoFragment extends Fragment {


    RecyclerView recyclerView;
    DoctoradoRecyclerAdapter doctoradoRecyclerAdapter;
    DoctoradoFragmentViewModel doctoradoFragmentViewModel;
    List<DoctoradoStudent> doctoradoList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_doctorado, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        doctoradoFragmentViewModel = ViewModelProviders.of(this).get(DoctoradoFragmentViewModel.class);

        fillRecyclerView();


    }


    void fillRecyclerView()
    {
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_students);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        doctoradoRecyclerAdapter = new DoctoradoRecyclerAdapter(doctoradoList);
        recyclerView.setAdapter(doctoradoRecyclerAdapter);

        doctoradoFragmentViewModel.getDoctoradoStudends().observe(this, new Observer<List<DoctoradoStudent>>() {

            @Override
            public void onChanged(@Nullable List<DoctoradoStudent> doctoradoStudents) {

                if(doctoradoStudents!=null)
                {
                    doctoradoList= doctoradoStudents;
                    doctoradoRecyclerAdapter.setAccountList(doctoradoList);
                }

            }
        });
    }
}
