package com.example.admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dkFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText gmail,pass,ht,cv,id_door;
    private Button dk;

    private FirebaseDatabase db;
    private DatabaseReference ref;
    private DatabaseReference mDatabase;
// ...

// ...


    private FirebaseAuth mAuth;

    public  String gm;


    public dkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dkFragment newInstance(String param1, String param2) {
        dkFragment fragment = new dkFragment();
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
        View view =inflater.inflate(R.layout.dk, container, false);
        gmail =view.findViewById(R.id.tk2);
        pass =view.findViewById(R.id.pass2);
        ht =view.findViewById(R.id.name);
        cv =view.findViewById(R.id.position);
        dk =view.findViewById(R.id.button);


        mDatabase = FirebaseDatabase.getInstance().getReference();


        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gm = gmail.getText().toString().concat("@gmail.com");
                creat_acc(gm,pass.getText().toString(),gmail.getText().toString());
                //write1(gmail.getText().toString(),ht.getText().toString(),cv.getText().toString());

            }
        });



        return view;

    }

    public void creat_acc(String gmail, String pass,String gm){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(gmail, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           write1(gm,ht.getText().toString(),cv.getText().toString());
                           Toast.makeText(getContext(),"Thành công",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(),"Lỗi ",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    public void write (String gmail,String ht,String cv){
        Product product =new Product(gmail,ht,cv,"","");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("accout").child(gmail).child(String.valueOf(product.getId())).setValue(product);
        myRef.setValue(gmail);

    }
    public void write1(String gmail,String ht,String cv){
        Product product =new Product(gmail,ht,cv,"","");


        mDatabase.child("users1").child(gmail).setValue(product);
    }

}