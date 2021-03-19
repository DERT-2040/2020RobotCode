package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.net.*;

public class VisionCommunication extends SubsystemBase{
    private double x;
    private double y;
    private double distance;
    private double width;
    private DatagramSocket clientSocket;
    private byte[] receiveData;
    private DatagramPacket receivePacket;
    private String inputData;

    public VisionCommunication(){

        //intiailizes the datagram objects
        try{
            clientSocket = new DatagramSocket(5805);
            clientSocket.setSoTimeout(10);
            receiveData = new byte[100];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
        }
        catch (Exception e){
            //System.out.println("Error: " + e.getMessage());
        }
    }

    public double[] getArrayData(){
        double[] finalArray = new double[5];
        double recievedPacket = 0;
        String distanceString = "";
        String xString = "";
        String yString = "";
        int commaCount = 0;

        //Trys to recieve a packet here
        try{
            clientSocket.receive(receivePacket);
            inputData = new String(receivePacket.getData());
            recievedPacket = 1;
            
        }
        catch (Exception e){
            //System.out.println("Error 2: " + e.getMessage()); 
            recievedPacket = 0;
        }

        //If Packet is recieved, then go through and parse the loop
        if(recievedPacket == 1){
            for(int i = 0; i < inputData.length(); i++){
                //If the target is not detected, the Pi sends "E", if E is detected, it counts as a packet not recieved
                if(inputData.charAt(i) == 'E'){
                    recievedPacket = 0;
                    break;
                }

                //Code for parsing the String sent from the Pi
                if(inputData.charAt(i) == ','){
                    commaCount++;
                    i++;
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
                if(commaCount > 2){
                }
            }

            //Checks if packet recieved is an E, if not then it does this code
            if(recievedPacket == 1){
                distance = Double.parseDouble(distanceString);
                x = Double.parseDouble(xString);
                y = Double.parseDouble(yString);
            }
        }

        //Sets the value of the variables to a number that will never be achieved Normally if packet isn't recieved
        if(recievedPacket == 0){
            distance = 999;
            x = 999;
            y = 999;
            width = 999;
        }
        
        //Simple measurement output
        //System.out.println(distance + " " + x + " " + y + " " + width);

        finalArray[0] = recievedPacket;
        finalArray[1] = distance;
        finalArray[2] = x;
        finalArray[3] = y;
        finalArray[4] = width;
        return finalArray;
    }

    public double getAngleAprox(){
        double finalAngle = 0;
        double x = getArrayData()[2];
        if(x != 999){
            finalAngle = -26+(0.0848 * x) + (-0.0000015 * x * x);
            //System.out.println(finalAngle);
            return finalAngle;
        }
        else{
            return 999;
        }
    }
}