package app.uangkas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Aboutdeveloper_be extends AppCompatActivity{
        private Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.about_devbe);
            button  = (Button) findViewById(R.id.home1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(app.uangkas.Aboutdeveloper_be.this, SplashActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


