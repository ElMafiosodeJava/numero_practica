package net.salesianos.client.threads;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerListener extends Thread {

  private DataInputStream inputStream;

  public ServerListener(DataInputStream inputStream) {
    this.inputStream = inputStream;
  }

  @Override
  public void run() {
    while (true) {
      String serverMessage;
      try {
        serverMessage = this.inputStream.readUTF();
        if (serverMessage.contains("acertado")) {
          System.out.println("\033[H\033[2J");
          System.out.println(serverMessage);
          System.out.println("juego terminado.");
          System.exit(0);
        }
        System.out.println(serverMessage);
        
      } catch (IOException e) {
        System.out.println("Problema recibiendo mensaje.");
      }
    }
  }
}
