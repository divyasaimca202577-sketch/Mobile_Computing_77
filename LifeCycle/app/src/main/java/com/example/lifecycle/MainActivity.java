package com.example.lifecycle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLog = findViewById(R.id.txtLog);

        appendLog("onCreate()");
    }

    private void appendLog(String message) {
        txtLog.append(message + "\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        appendLog("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        appendLog("onResume()");

        // Wait for 20 seconds and then close the activity
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 20000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appendLog("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        appendLog("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        appendLog("onRestart()");
    }

    @Override
    protected void onDestroy() {
        appendLog("onDestroy()");
        super.onDestroy();
    }
}
















//package com.example.lifecycle;
//
//import android.os.Bundle;
//
//import com.google.android.material.snackbar.Snackbar;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.view.View;
//
//import androidx.core.view.WindowCompat;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//
//import com.example.lifecycle.databinding.ActivityMainBinding;
//
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//
//        TextView txtLog;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            txtLog = findViewById(R.id.txtLog);
//
//            appendLog("onCreate()");
//        }
//
//        private void appendLog(String message) {
//            txtLog.append(message + "\n");
//        }
//
//        @Override
//        protected void onStart() {
//            super.onStart();
//            appendLog("onStart()");
//
//        }
//
//
//
//        @Override
//        protected void onResume() {
//            super.onResume();
//            appendLog("onResume()");
//        }
//
//        @Override
//        protected void onPause() {
//            super.onPause();
//            appendLog("onPause()");
//        }
//
//        @Override
//        protected void onStop() {
//            super.onStop();
//            appendLog("onStop()");
//        }
//
//        @Override
//        protected void onRestart() {
//            super.onRestart();
//            appendLog("onRestart()");
//        }
//
//        @Override
//        protected void onDestroy() {
//            appendLog("onDestroy()");
//            super.onDestroy();
//        }
//    }