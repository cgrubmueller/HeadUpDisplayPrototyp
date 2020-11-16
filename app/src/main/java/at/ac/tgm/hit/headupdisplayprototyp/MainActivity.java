package at.ac.tgm.hit.headupdisplayprototyp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import at.ac.tgm.hit.projekte.headupdisplay_test.bluetooth.BluetoothConnector;
import at.ac.tgm.hit.projekte.headupdisplay_test.bluetooth.Utils;
import at.ac.tgm.hit.projekte.headupdisplay_test.data.DataWriterAndroid;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import at.ac.tgm.hit.projekte.headupdisplay_test.exceptions.BluetoothException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        try {
            BluetoothSocket socket = Utils.init();
            System.out.println("Socket erstellt!");
            BluetoothConnector btc= new BluetoothConnector(socket,tv);

        } catch (IOException e) {
            tv.setText(tv.getText()+"\n"+e.getStackTrace());
        } catch (NoSuchMethodException e) {
            tv.setText(tv.getText()+"\n"+e.getStackTrace());
        } catch (InvocationTargetException e) {
            tv.setText(tv.getText()+"\n"+e.getStackTrace());
        } catch (IllegalAccessException e) {
            tv.setText(tv.getText()+"\n"+e.getStackTrace());
        } catch (BluetoothException e) {
            tv.setText(tv.getText()+"\n"+e.toString());

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveCSVData(View view) {
        //Es wird ein String mit dem Pfad zu der "MyCsvFile.csv"-Datei zurück
        String csv = (this.getApplicationContext().getFilesDir().getAbsolutePath() + "/fahrdaten.csv");
        System.out.println(csv);
        //ruft die Methode auf, die die Daten speichert
        DataWriterAndroid.writeData(csv);
    }
}