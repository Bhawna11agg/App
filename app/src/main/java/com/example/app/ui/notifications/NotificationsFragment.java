package com.example.app.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.app.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private Button button;
    private TextView textView;
    private IntentIntegrator qrscan;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //  notificationsViewModel =
        //        ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        button=root.findViewById (R.id.button);
        textView=root.findViewById (R.id.text1);

        qrscan=new IntentIntegrator(getActivity());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrscan.initiateScan ();
            }
        });
        return root;
    }
    @Override
    public void onActivityResult(int requestcode, int resultcode, Intent data){
        IntentResult result=IntentIntegrator.parseActivityResult (requestcode,resultcode,data);
        if(result!=null){
            if(result.getContents ()==null){
                Toast.makeText (getContext(),"Result no found",Toast.LENGTH_LONG).show ();
            }
            else{
                try{
                    String obj=new String (result.getContents ());
                    textView.setText (obj);
                }
                catch (Exception e){
                    e.printStackTrace ();
                    Toast.makeText (getContext(),result.getContents (),Toast.LENGTH_LONG).show ();
                }
            }
        }
        else{
            super.onActivityResult (requestcode,resultcode,data);
        }
    }


    }

