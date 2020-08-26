package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bladeofgod.flutteragoralive.R;

import agora.EngineConfig;
import agora.stats.StatsManager;
import app.OwnApplication;
import io.agora.rtc.RtcEngine;

public class InputChannelActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_channel);

        initView();
    }

    private void initView() {
        etNumber = findViewById(R.id.et_channel);
        etNumber.addTextChangedListener(textWatcher);
        btnStart = findViewById(R.id.btn_start);
        btnStart.setEnabled(false);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRoleActivity();
            }
        });

    }

    public void gotoRoleActivity() {
        Intent intent = new Intent(this, SetRoleActivity.class);
        String room = etNumber.getText().toString();
        config().setChannelName(room);
        startActivity(intent);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            btnStart.setEnabled(!TextUtils.isEmpty(editable));

        }
    };


    ///base below

    protected EngineConfig config() {
        return application().engineConfig();
    }

    protected StatsManager statsManager() { return application().statsManager(); }

    protected RtcEngine rtcEngine() {
        return application().rtcEngine();
    }
    protected OwnApplication application() {
        return (OwnApplication) getApplication();
    }
}
