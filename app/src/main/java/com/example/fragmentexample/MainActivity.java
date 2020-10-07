package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFirstFragment, btnSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirstFragment = (Button) findViewById(R.id.button_first_fragment);
        btnSecondFragment = (Button) findViewById(R.id.button_second_fragment);

        btnFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new firstFragment());
            }
        });

        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new secondFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0)
            super.onBackPressed();
        else {
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().getFragments().get(count)).commit();
            getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().getFragments().get(count-1)).commit();
//            getSupportFragmentManager().executePendingTransactions();
            getSupportFragmentManager().popBackStack();
//            getSupportFragmentManager().executePendingTransactions();
//            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, getSupportFragmentManager().getFragments().get(count-1)).commit();
//            getSupportFragmentManager().executePendingTransactions();
        }
    }
}