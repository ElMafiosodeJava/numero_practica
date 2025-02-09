package net.salesianos.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import net.salesianos.server.threads.ClientHandler;
import net.salesianos.utils.Constants;

public class ServerApp {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT);
    System.out.println("Servidor levantado en el puerto " + serverSocket.getLocalPort());

    Random random = new Random();

    int randomNumber = random.nextInt(101);

    ArrayList<DataOutputStream> clientsOutputs = new ArrayList<>();
    
    while (true) {
      System.out.println("Esperando conexión entrante...");
      Socket clientSocket = serverSocket.accept();

      DataOutputStream clientOutputStream = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
      clientsOutputs.add(clientOutputStream);

      DataInputStream clientInputStream = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
      String name = clientInputStream.readUTF();
 
      ClientHandler clientHandler = new ClientHandler(clientInputStream, name, clientsOutputs, randomNumber);
      clientHandler.start();
      
      
      
    }
  }
}
