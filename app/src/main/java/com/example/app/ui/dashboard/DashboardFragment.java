package com.example.app.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.app.ui.dashboard.DashboardViewModel;
import com.example.app.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    Button btn;
    EditText edt1,edt2,edt3,edt4,edt5;
    DatabaseReference dbref=FirebaseDatabase.getInstance().getReference();
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // dashboardViewModel =
        //        ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

       /* final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        btn=root.findViewById(R.id.Submit);
        edt1=root.findViewById(R.id.editText1);
        edt2=root.findViewById(R.id.editText2);
        edt3=root.findViewById(R.id.editText3);
        edt4=root.findViewById(R.id.editText4);
        edt5=root.findViewById(R.id.editText5);
        btn.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {

        String note1=edt1.getText().toString();
        String note2=edt2.getText().toString();
        String note3=edt3.getText().toString();
        String note4=edt4.getText().toString();
        String note5=edt5.getText().toString();
        dbref.child("Name").push().setValue(note1);
        dbref.child("Phone Number").push().setValue(note2);
        dbref.child("Email").push().setValue(note3);
        dbref.child("Car Number").push().setValue(note4);
        dbref.child("Car Model").push().setValue(note5);
    }
}
