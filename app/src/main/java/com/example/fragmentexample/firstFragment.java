package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class firstFragment extends Fragment {
    View view;
    Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        firstButton = (Button) view.findViewById(R.id.firstButton);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), "First Fragment", Toast.LENGTH_LONG).show();

                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(firstFragment.this).commit();
//                getActivity().getSupportFragmentManager().popBackStack();
                getActivity().getSupportFragmentManager().beginTransaction().hide(firstFragment.this).commit();
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new secondFragment()).commit();

//                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new secondFragment());
//                getActivity().getSupportFragmentManager().beginTransaction().commit();

//                getFragmentManager().beginTransaction().addToBackStack("xyz");
//                getFragmentManager().beginTransaction().hide(firstFragment.this);
//                getFragmentManager().beginTransaction().add(R.id.frameLayout, new secondFragment());
//                getFragmentManager().beginTransaction().commit();
            }
        });

        return view;
    }
}
