package at.ac.tgm.hit.projekte.headupdisplay_test.bluetooth;


import android.bluetooth.BluetoothSocket;
import android.widget.TextView;
import io.github.macfja.obd2.Commander;
import io.github.macfja.obd2.command.livedata.AbsoluteLoadValue;
import io.github.macfja.obd2.exception.ExceptionResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;



public class BluetoothConnector {
    //BluetoothManager bluetoothManager = (BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE,null);
    //BluetoothDevice mBluetoothDevice = bluetoothManager.getAdapter() .getRemoteDevice("deviceAddress");
    private Commander commander;

    public BluetoothConnector(BluetoothSocket OBD2, TextView tv) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        commander = new Commander();

        tv.setText(tv.getText()+"\nInstanz vom Commander wurde erstellt!");
        commander.setCommunicationInterface(OBD2.getOutputStream(), OBD2.getInputStream());
        tv.setText(tv.getText()+"\nCommander konnte erstellt und verbunden werden!");
        try {
            System.out.println(""+commander.sendCommand(new AbsoluteLoadValue()));
        } catch (ExceptionResponse exceptionResponse) {
            exceptionResponse.printStackTrace();
            tv.setText(tv.getText()+"\n"+exceptionResponse.getStackTrace());
        }
        // Should print something like "OBDII to RS232 Interpreter"
        // System.out.println(commander.sendCommand(new EngineRPM()));
        // Should print something like "875rpm"

    }


    public String getSpeed() throws IOException {
        return "";//commander.sendCommand(new VehicleSpeed()).getFormattedString();
    }

    public String getSpeedUnit() throws IOException {
        return "";//commander.sendCommand(new VehicleSpeed()).getUnit().toString();
    }

    public String getBatteryLevel() throws IOException {
        return "";//commander.sendCommand(new FuelLevel()).getFormattedString();
    }

    public String getBatteryLevelUnit() throws IOException {
        return "";//commander.sendCommand(new FuelLevel()).getUnit().toString();
    }
    public String getMilage() throws IOException {
        return "";//commander.sendCommand(new VehicleSpeed()).getFormattedString();
    }
}