package app.uangkas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Aboutdeveloper extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_dev);
        button  = (Button) findViewById(R.id.home1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Aboutdeveloper.this, SplashActivity.class);
                startActivity(intent);
            }
        });


    button = (Button) findViewById(R.id.abtfe);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Aboutdeveloper.this, Aboutdeveloper_be.class);
            startActivity(intent);
        }
    });
}
}
