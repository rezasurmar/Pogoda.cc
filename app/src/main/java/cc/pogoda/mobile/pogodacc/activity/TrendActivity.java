package cc.pogoda.mobile.pogodacc.activity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import cc.pogoda.mobile.pogodacc.R;
import cc.pogoda.mobile.pogodacc.activity.trend.pressure.PressureTrendFragment;

public class TrendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stationName = (String)getIntent().getExtras().get("station");
        setContentView(R.layout.activity_trend);

        NavArgument.Builder builder = new NavArgument.Builder();

        Bundle bundle = new Bundle();
        bundle.putString("station", stationName);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_pressure, R.id.navigation_temperature, R.id.navigation_wind)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.mobile_navigation);
        builder.setDefaultValue(stationName);
        navGraph.addArgument("station", builder.build());
        navController.setGraph(navGraph, bundle);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
//
//        NavArgument.Builder builder = new NavArgument.Builder();
//        builder.setDefaultValue(stationName);
//        navGraph.addArgument("station", builder.build());
//       // navController.get
//        navController.setGraph(navGraph);

    }

}