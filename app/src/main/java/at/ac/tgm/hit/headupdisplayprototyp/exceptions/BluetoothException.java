package at.ac.tgm.hit.projekte.headupdisplay_test.exceptions;

import at.ac.tgm.hit.projekte.headupdisplay_test.bluetooth.BluetoothConnector;

public class BluetoothException extends Exception{
    String infotext="";
    public BluetoothException(String infotext){
        this.infotext=infotext;
    }
    public String toString(){
        return infotext;
    }
}
