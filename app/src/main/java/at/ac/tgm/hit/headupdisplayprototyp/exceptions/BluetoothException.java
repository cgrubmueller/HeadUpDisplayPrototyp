package at.ac.tgm.hit.headupdisplayprototyp.exceptions;

public class BluetoothException extends Exception{
    String infotext="";
    public BluetoothException(String infotext){
        this.infotext=infotext;
    }
    public String toString(){
        return infotext;
    }
}
