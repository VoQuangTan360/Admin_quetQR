package com.example.admin.door;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.Product;
import com.example.admin.R;
import com.example.admin.list.listAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link doorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class doorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText id, name;
    private Button btn;
    private RecyclerView rcv;
    public doorAdapter doorAdapter1;
    private List<Door> mlistdoor;
    private DatabaseReference mDatabase;
    public doorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment doorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static doorFragment newInstance(String param1, String param2) {
        doorFragment fragment = new doorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_door, container, false);

        id =view.findViewById(R.id.tv_id);
        name =view.findViewById(R.id.tv_name);
        rcv =view.findViewById(R.id.rcv);
        btn =view.findViewById(R.id.btn);

        mlistdoor = new ArrayList<>();
        getdata();
        doorAdapter1 =new doorAdapter(mlistdoor);
        rcv.setAdapter(doorAdapter1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write1(id.getText().toString().trim(),name.getText().toString().trim());
            }
        });
        return view;
    }
    private void getdata(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("door");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Door door1 = dataSnapshot.getValue(Door.class);
                    mlistdoor.add(door1);
                    //rcv.setAdapter(new doorAdapter(mlistdoor));


                }

                //doorAdapter1.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Lỗi ",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void write1(String id,String name){
        doorwrite product =new doorwrite(id,name);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("door").child(id).setValue(product);
    }
}