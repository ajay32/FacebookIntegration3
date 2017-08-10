package ajaymehta.facebookintegration3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;
import com.stfalcon.socialauthhelper.fb.FacebookClient;
import com.stfalcon.socialauthhelper.fb.model.FacebookProfile;

public class Second extends AppCompatActivity {

    private FacebookClient facebookClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button bkt = (Button) findViewById(R.id.logoutbtn);

        //==================logout=======================

        bkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                startActivity(new Intent(getApplicationContext() , MainActivity.class));
            }
        });

//==================================================================================================================
        final TextView tvFacebook = (TextView) findViewById(R.id.tv_facebook);
        final ImageView ivFacebook = (ImageView) findViewById(R.id.iv_facebook);


        facebookClient = new FacebookClient(this);


        facebookClient.getProfile(new FacebookClient.FbResultCallback() {
            @Override
            public void onProfileLoaded(FacebookProfile facebookProfile) {
                //after authorization successful you have access to user profile and Access Token
                tvFacebook.setText(getString(R.string.profileInfo,
                        facebookProfile.getName(),
                           facebookProfile.getId(),
                        facebookClient.getToken()) +"\n" + facebookProfile.getGender() +"\n" + facebookProfile.getName() + "\n"+ facebookProfile.getLocale()+ "\n"+ facebookProfile.getBirthday());

                ivFacebook.setVisibility(View.VISIBLE);
                Picasso.with(Second.this).load(
                        facebookProfile.getPicture().data.url).into(ivFacebook);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebookClient.onActivityResult(requestCode, resultCode, data);

    }






}
