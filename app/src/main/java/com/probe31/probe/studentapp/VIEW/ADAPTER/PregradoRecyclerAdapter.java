package com.probe31.probe.studentapp.VIEW.ADAPTER;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.probe31.probe.studentapp.MODEL.PregradoStudent;
import com.probe31.probe.studentapp.MODEL.Student;
import com.probe31.probe.studentapp.R;

import java.util.List;

public class PregradoRecyclerAdapter extends RecyclerView.Adapter<PregradoRecyclerAdapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView idstudent_text;
        TextView firstname_text;
        TextView lastname_text;

        public ViewHolder(View view) {
            super(view);
            idstudent_text = (TextView)view.findViewById(R.id.idstudent_text);
            firstname_text = (TextView)view.findViewById(R.id.firstname_text);
            lastname_text = (TextView)view.findViewById(R.id.lastname_text);
        }
    }

    List<PregradoStudent> studentList;

    public PregradoRecyclerAdapter(List<PregradoStudent> studentList) {
        this.studentList = studentList;
    }

    @Override
    public PregradoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_adapter, parent, false);

        return new PregradoRecyclerAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PregradoRecyclerAdapter.ViewHolder holder, int position) {
        PregradoStudent student = studentList.get(position);
        holder.idstudent_text.setText(student.getIdStudent());
        holder.firstname_text.setText(student.getFirstName());
        holder.lastname_text.setText(student.getLastName());
    }

    public void setAccountList(List<PregradoStudent> studentList) {
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(studentList != null){
            return studentList.size();
        }
        return 0;

    }

}
