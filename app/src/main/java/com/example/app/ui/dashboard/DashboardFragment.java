package com.example.app.ui.dashboard;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.app.MainActivity;
import com.example.app.Profile;
import com.example.app.User;
import com.example.app.ui.dashboard.DashboardViewModel;
import com.example.app.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardFragment extends Fragment{
    int count=0;
    Button btn;
    EditText edt1,edt2,edt3,edt4,edt5;
    final DatabaseReference dbref=FirebaseDatabase.getInstance().getReference();
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // dashboardViewModel =
        //        ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        edt1 = root.findViewById(R.id.editText1);
        edt2 = root.findViewById(R.id.editText2);
        edt3 = root.findViewById(R.id.editText3);
        edt4 = root.findViewById(R.id.editText4);
        edt5 = root.findViewById(R.id.editText5);

            dbref.child("Profile").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    User user = dataSnapshot.getValue(User.class);
                    edt1.setText("Name:" + user.getName());
                    edt2.setText("Phone Number: " + user.getPhone());
                    edt3.setText("Email ID: " + user.getEmail());
                    edt4.setText("Car Number: " + user.getCarNumber());
                    edt5.setText("Car Model: " + user.getCarModel());
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        return root;
    }
       /* final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

}
