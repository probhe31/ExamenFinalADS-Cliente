package com.probe31.probe.studentapp.VIEW.ADAPTER;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.probe31.probe.studentapp.MODEL.DoctoradoStudent;
import com.probe31.probe.studentapp.MODEL.Student;
import com.probe31.probe.studentapp.R;

import java.util.List;

public class DoctoradoRecyclerAdapter extends RecyclerView.Adapter<DoctoradoRecyclerAdapter.ViewHolder>{

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

    List<DoctoradoStudent> studentList;

    public DoctoradoRecyclerAdapter(List<DoctoradoStudent> studentList) {
        this.studentList = studentList;
    }

    @Override
    public DoctoradoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_adapter, parent, false);

        return new DoctoradoRecyclerAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DoctoradoRecyclerAdapter.ViewHolder holder, int position) {
        DoctoradoStudent student = studentList.get(position);
        holder.idstudent_text.setText(student.getIdStudent());
        holder.firstname_text.setText(student.getFirstName());
        holder.lastname_text.setText(student.getLastName());
    }

    public void setAccountList(List<DoctoradoStudent> studentList) {
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
