package must.ac.ug.csce.isophel.isophelxmlcolorswap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity<MyBroadcastReceiver> extends AppCompatActivity {
    private MyReceiver isanreceiver;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView taptext = (TextView) findViewById(R.id.txtcolor);
        Button tapmebtn = (Button) findViewById(R.id.buttontap);
        IntentFilter intentFilter = new IntentFilter("com.must.ac.ug.csce.Isophel.IsophelProgColorSwap");
        isanreceiver = new MyReceiver();
        registerReceiver(isanreceiver, intentFilter);


        final Random random = new Random();
        tapmebtn.setOnClickListener(v -> {
            float red = random.nextFloat();

            float green = random.nextFloat();
            float blue = random.nextFloat();
            taptext.setText("r" + String.valueOf(red) + "   g" + String.valueOf(green + " b" + String.valueOf(blue)));
            taptext.setTextColor(Color.rgb(red, green, blue));


        });

    }
        class MyReceiver extends BroadcastReceiver {
            public void onReceive(Context context, Intent intent) {
                String message = intent.getStringExtra("message");

                if (intent.getAction().equals("com.must.ac.ug.csce.Isophel.IsophelProgColorSwap")) {
                    // Display message
                    Toast.makeText(context, "" + message + "New Broad cast", Toast.LENGTH_LONG).show();
                }
            }
        }


}
