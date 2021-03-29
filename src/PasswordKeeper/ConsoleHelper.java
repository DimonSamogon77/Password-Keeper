package PasswordKeeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void writeMessage(String message){
        System.out.println(message);
    }

    public String readMessage(){
        try{
            return reader.readLine();
        }catch (IOException ignored){

        }
        return null;
    }
}
