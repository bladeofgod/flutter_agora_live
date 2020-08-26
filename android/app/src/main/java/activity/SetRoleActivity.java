package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bladeofgod.flutteragoralive.R;

import io.agora.rtc.Constants;

public class SetRoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_role);

        initView();
    }

    private void initView() {

        findViewById(R.id.btn_pusher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onJoinAsBroadcaster();

            }
        });

        findViewById(R.id.btn_viewer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onJoinAsAudience();

            }
        });
    }

    public void onJoinAsBroadcaster() {
        gotoLiveActivity(Constants.CLIENT_ROLE_BROADCASTER);
    }

    public void onJoinAsAudience() {
        gotoLiveActivity(Constants.CLIENT_ROLE_AUDIENCE);
    }

    private void gotoLiveActivity(int role) {
        Intent intent = new Intent(getIntent());
        intent.putExtra(constant.Constants.KEY_CLIENT_ROLE, role);
        intent.setClass(getApplicationContext(), LiveActivity.class);
        startActivity(intent);
    }
}
