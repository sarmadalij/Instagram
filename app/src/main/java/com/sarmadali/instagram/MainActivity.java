package com.sarmadali.instagram;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationBarView;
import com.sarmadali.instagram.databinding.ActivityMainBinding;
import com.sarmadali.instagram.ui.dashboard.SearchFragment;
import com.sarmadali.instagram.ui.home.HomeFragment;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
//    Toolbar toolbar;

   Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
//        NavController navController = Navigation.findNavController(this, R.id.main_fragment);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();

//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);


        //hide Action toolbar

//        getSupportActionBar().hide();

        //toolbar
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        //camera access
        ImageView cameraToolBar = toolbar.findViewById(R.id.camera);

        cameraToolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Camera is Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        //navView menu

        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.home)
                {
                    HomeFragment homeFragment = new HomeFragment();
//                   getSupportFragmentManager().beginTransaction().remove(yourFragment).commitAllowingStateLoss();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment , homeFragment);
                    transaction.commit();

//                    this.getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                }

                 else if (item.getItemId() == R.id.search)
                {
                    SearchFragment searchFragment = new SearchFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment , searchFragment);
                    transaction.commit();

                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId() == R.id.user)
                {
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment , profileFragment);
                    transaction.commit();

                    Toast.makeText(MainActivity.this, "Welcome to Your Profile", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });




    }

}