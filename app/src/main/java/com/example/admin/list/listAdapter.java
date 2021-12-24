package com.example.admin.list;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.R;

import java.util.List;


public class listAdapter extends RecyclerView.Adapter<listAdapter.myviewholder>
{


    List<User> myusers;

    public listAdapter(List<User> users) {
        this.myusers = users;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.donglist,parent,false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.ht.setText(myusers.get(position).getHt());
        holder.cv.setText(myusers.get(position).getCv());
        holder.iddoor.setText(myusers.get(position).getIddoor());
    }

    @Override
    public int getItemCount() {
        return myusers.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{


        TextView ht,cv,iddoor;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            ht=itemView.findViewById(R.id.ht);
            cv=itemView.findViewById(R.id.cv);
            iddoor=itemView.findViewById(R.id.iddoor);
        }
    }

}
