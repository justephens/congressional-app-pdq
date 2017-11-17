package plp.pdq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    Button btnSignOut, btnPersonalInfo, btnPayOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnSignOut = (Button) findViewById(R.id.buttonSignOut);
        btnPersonalInfo = (Button) findViewById(R.id.buttonPersonInfo);
        btnPayOpt = (Button) findViewById(R.id.buttonPaymentOpt);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });

        btnPayOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity (new Intent(SettingsActivity.this, PaymentActivity.class));
            }
        });
    }
}
