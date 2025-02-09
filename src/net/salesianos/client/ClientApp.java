package net.salesianos.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

import net.salesianos.client.threads.ServerListener;
import net.salesianos.utils.Constants;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre de usuario:");

        String name = scanner.nextLine();
        

        Socket socket = new Socket("localhost", Constants.SERVER_PORT);

        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        outputStream.writeUTF(name);
        outputStream.flush();

        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        ServerListener serverListenerThread = new ServerListener(inputStream);
        serverListenerThread.start();
        
        System.out.println("Escribe un valor entre 0 y 100, te iré dando pistas para que averigues qué número es.");
        while (true) {
            
            try {
                System.out.print("-> ");
                int message = scanner.nextInt();
                if (message <= 100 && message >= 0) {
                    outputStream.writeInt(message);
                    outputStream.flush();
                } else {
                    System.out.println("");
                    System.out.println("Los valores deben ser comprendidos entre 0 y 100");
                }
            } catch (InputMismatchException e) {
                System.out.println("Esto no es un número entero, crema.");
                scanner.nextLine();
            }

        }
        
    }
    
}