package com.example.admin.door;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.R;

import java.util.List;

public class doorAdapter extends RecyclerView.Adapter<doorAdapter.doorViewholder>{

    private List <Door> mListdoor;

    public doorAdapter(List<Door> mListdoor) {
        this.mListdoor = mListdoor;
    }

    @NonNull
    @Override
    public doorViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_door,parent,false);
        return new doorViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull doorViewholder holder, int position) {
         Door door1 =mListdoor.get(position);
         if(door1==null)
             return;
         holder.tv_id.setText("ID: "+ door1.getId());
         holder.tv_name.setText("Name: "+ door1.getName());

    }

    @Override
    public int getItemCount() {
        if(mListdoor != null){
            return mListdoor.size();
        }

        return 0;
    }

    public class doorViewholder extends RecyclerView.ViewHolder{

        private TextView tv_id;
    private TextView tv_name;



        public doorViewholder(@NonNull View itemView) {
            super(itemView);
            tv_id=itemView.findViewById(R.id.tv_id);
            tv_name=itemView.findViewById(R.id.tv_name);
        }
    }
}
