package at.ac.tgm.hit.headupdisplayprototyp.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import at.ac.tgm.hit.headupdisplayprototyp.exceptions.BluetoothException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;


public class Utils {
    public static BluetoothSocket init() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, BluetoothException {
        String deviceMac="";
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothSocket s1=null;
        System.out.println("1");
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            throw new BluetoothException("Device doesn't support BLuetooth!");
        }
        else if (!bluetoothAdapter.isEnabled()){
            throw new BluetoothException("Bluetooth disabled");
        }
        else  {
            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

            if (pairedDevices.size() > 0) {
                // There are paired devices. Get the name and address of each paired device.
                for (BluetoothDevice device : pairedDevices) {
                    System.out.println("device Name: " +device.getName() + "\t Mac: "+ device.getAddress());
                    //***********************Den Gerätenamen des Bluetooth dongles im String in der If-Anweisung eingeben**************
                    if(device.getName().equals("CBT")||device.getName().equals("CAN OBDII")||device.getName().equals("KONNWEI")){
                        deviceMac=device.getAddress();
                        System.out.println("Dein gesuchtes Device hat die Adresse: "+ deviceMac);
                        System.out.println("till here");
                        s1= device.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                        System.out.println("till there");
                        Method m = device.getClass().getMethod("createRfcommSocket", new Class[] {int.class});
                        s1=(BluetoothSocket) m.invoke(device,1);
                    }
                }
            }
        }
        return s1;
    }
}