package ajaymehta.facebookintegration3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;


public class MainActivity extends AppCompatActivity {

    //======================Dont forget to put INTERNET permission ..suck it wasted a lot of time ....ffuvk....=============

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFb = (Button) findViewById(R.id.btn_fb);

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Second.class));
            }
        });


    }




}
