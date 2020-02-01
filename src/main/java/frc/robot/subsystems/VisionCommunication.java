package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.net.*;

public class VisionCommunication extends SubsystemBase{
    private double x;
    private double y;
    private double distance;
    private double width;
    private DatagramSocket clientSocket;
    private InetAddress IPAddress;
    private byte[] receiveData;
    private DatagramPacket receivePacket;
    private String inputData;

    public VisionCommunication(){
        try{
            clientSocket = new DatagramSocket();
            IPAddress = InetAddress.getByName("10.20.40.69");
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean getData(){
        boolean recievedPacket = false;
        String distanceString = "";
        String xString = "";
        String yString = "";
        String widthString = "";
        int commaCount = 0;
        try{
            clientSocket.receive(receivePacket);
            inputData = new String(receivePacket.getData());
            recievedPacket = true;
        }
        catch (Exception e){
            System.out.println("Error 2: " + e.getMessage()); 
            recievedPacket = false;
        }
        if(!recievedPacket){
            for(int i = 0; i < inputData.length(); i++){
                if(inputData.charAt(i) == ','){
                    commaCount++;
                }
                if(commaCount == 0){
                    distanceString += inputData.charAt(i);
                }
                if(commaCount == 1){
                    xString += inputData.charAt(i);
                }
                if(commaCount == 2){
                    yString += inputData.charAt(i);
                }
                if(commaCount == 3){
                    widthString += inputData.charAt(i);
                }
            }

            distance = Double.parseDouble(distanceString);
            x = Double.parseDouble(xString);
            y = Double.parseDouble(yString);
            width = Double.parseDouble(widthString);
        }
        System.out.println(distance + " " + x + " " + y + " " + width);

        return recievedPacket;
    }
    public double getDistance(){
        double modifiedDistance = distance;
        if(!getData()){
            modifiedDistance = 999;
        }
        return modifiedDistance;
    }

    public double getX(){
        double modifiedX = x;;
        if(!getData()){
            modifiedX = 999;
        }
        return modifiedX;
    }

    public double getY(){
        double modifiedY = y;
        if(!getData()){
            modifiedY = 999;
        }
        return modifiedY;
    }

    
}