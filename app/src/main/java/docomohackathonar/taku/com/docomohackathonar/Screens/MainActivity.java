package docomohackathonar.taku.com.docomohackathonar.Screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import docomohackathonar.taku.com.docomohackathonar.R;
import eu.kudan.kudan.ARAPIKey;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.show_ar)
    Button mShowAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mShowAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowARActivity.class);
                startActivity(intent);
            }
        });
        ARAPIKey apiKey = ARAPIKey.getInstance();
        apiKey.setAPIKey(getString(R.string.api_key));
    }


}
