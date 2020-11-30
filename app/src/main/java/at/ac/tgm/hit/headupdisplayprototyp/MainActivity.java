package at.ac.tgm.hit.headupdisplayprototyp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothSocket;
import android.widget.TextView;

import at.ac.tgm.hit.headupdisplayprototyp.bluetooth.Utils;
import at.ac.tgm.hit.headupdisplayprototyp.exceptions.BluetoothException;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private SpeedReader speed;
    private FuelReader fuel;
    private BluetoothSocket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        this.speed = new SpeedReader();
        this.fuel = new FuelReader();

        try {
            this.socket = Utils.getSocket(Utils.getDevice());

            Updater updater = new Updater(new Runnable() {
                @Override
                public void run() {
                    /*
                    SpeedView.setText(speed.getSpeed());
                    FuelView.setText(fuel.getFuelLevel();
                     */
                }
            }, 500);// 500ms => 0.5s

            updater.startUpdates();

        } catch (IOException e) {
            //errorView.setText(e.getMessage);
        } catch (BluetoothException e) {
            //errorView.setText(e.getMessage);
        }
    }
}