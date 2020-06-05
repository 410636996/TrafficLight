package tw.edu.pu.s1063699.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txv,txv1,txv2;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);
    }

    public void StartGame(View v){
        txv=(EditText) findViewById(R.id.txv1);
        txv1=(EditText) findViewById(R.id.txv2);
        txv2=(EditText) findViewById(R.id.txv3);
        if(txv.getText().toString().equals("")||txv1.getText().toString().equals("")||txv2.getText().toString().equals("")) {
            Toast toast = Toast.makeText(MainActivity.this,
                    "燈號的秒數不能為空白",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }else if(txv.getText().toString().equals("0")||txv1.getText().toString().equals("0")||txv2.getText().toString().equals("0")){
            Toast toast = Toast.makeText(MainActivity.this,
                    "燈號的秒數不能為0",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        else{
            Intent it = new Intent();
            it.setClass(this, GameActivity.class);
            startActivity(it);
            finish();
        }
    }

    public void EndApp(View v){
        finish();
    }

}