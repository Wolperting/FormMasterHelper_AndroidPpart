package com.wolper.formmasterhelper;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SetUpSecurityFragment extends Fragment {


    private EditText text_forIp;
    private Button button_exit;
    private Button button_save;
    private MainStorageSingleton mainStorageSingleton;


    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setRetainInstance(true);
        mainStorageSingleton = MainStorageSingleton.getInstance();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.security_setup_fragment, container, false);


        //Button exit
        button_exit = (Button) v.findViewById(R.id.button_exit_paswd);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


        //Button save
        button_save = (Button) v.findViewById(R.id.button_save_paswrd);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setResult(Activity.RESULT_OK, new Intent().putExtra("password", text_forIp.getText().toString()));
                getActivity().onBackPressed();
            }
        });


        //Text field for enterring IP address for server
        text_forIp = (EditText)v.findViewById(R.id.password);
        text_forIp.setText(mainStorageSingleton.password);
        text_forIp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                // toDo - Replace server string
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        return v;
    }

}