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

    public double[] getData(){
        double[] finalArray = new double[5];
        double recievedPacket = 0;
        String distanceString = "";
        String xString = "";
        String yString = "";
        String widthString = "";
        int commaCount = 0;
        try{
            clientSocket.receive(receivePacket);
            inputData = new String(receivePacket.getData());
            recievedPacket = 1;
        }
        catch (Exception e){
            System.out.println("Error 2: " + e.getMessage()); 
            recievedPacket = 0;
        }
        if(recievedPacket == 1){
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

        if(recievedPacket == 0){
            distance = 999;
            x = 999;
            y = 999;
            width = 999;
        }
        
        System.out.println(distance + " " + x + " " + y + " " + width);

        finalArray[0] = recievedPacket;
        finalArray[1] = distance;
        finalArray[2] = x;
        finalArray[3] = y;
        finalArray[4] = width;
        return finalArray;
    }

    public double getDistance(){
        return distance;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getWidth(){
        return width;
    }
}