package net.salesianos.server.threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;

public class ClientHandler extends Thread {

  private DataInputStream clientInputStream;
  private String name;
  private ArrayList<DataOutputStream> clientsOutputs;

  Random random = new Random();

  private int numberRandom;

  public ClientHandler(DataInputStream clientInputStream, String name,
    ArrayList<DataOutputStream> clientsOutputsStream, int numberRandom) throws IOException {
    this.clientInputStream = clientInputStream;
    this.name = name;
    this.clientsOutputs = clientsOutputsStream;
    this.numberRandom = numberRandom;
  }

  @Override
  public void run() {
    try {

      while (true) {
        int numberClient = clientInputStream.readInt();

        if (numberClient == numberRandom) {
          String receivedMessage = "El cliente " + this.name + " ha acertado el número que es " + numberRandom;
          System.out.println(receivedMessage);
          
          for (DataOutputStream dataOutputStream : clientsOutputs) {
            dataOutputStream.writeUTF(receivedMessage);
            dataOutputStream.flush();
            dataOutputStream.writeUTF("");
            dataOutputStream.flush();
          }

          break;

        } else if(numberClient > numberRandom){
          String receivedMessage = this.name + ": " + "El número " + numberClient + " es mayor al número propiciado por el servidor.";
          System.out.println(receivedMessage);

          for (DataOutputStream dataOutputStream : clientsOutputs) {
            dataOutputStream.writeUTF(receivedMessage);
            dataOutputStream.flush();
            dataOutputStream.writeUTF("");
            dataOutputStream.flush();
          }

        }else if(numberClient < numberRandom){
          String receivedMessage = this.name + ": " + "El número " + numberClient + " es menor al número propiciado por el servidor.";
          System.out.println(receivedMessage);  

          for (DataOutputStream dataOutputStream : clientsOutputs) {
            dataOutputStream.writeUTF(receivedMessage);
            dataOutputStream.flush();
            dataOutputStream.writeUTF("");
            dataOutputStream.flush();
          }
        }
      }
      
    } catch (SocketException se) {
      System.out.println("Conexión cerrada con cliente " + this.name + ".");
    } catch (IOException ioe) {
      System.out.println("Input output exception.");
    }
  }
}
