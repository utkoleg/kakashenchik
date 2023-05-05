package Server;

import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(2020)) {
            System.out.println("Server started");
            System.out.println("waiting for connections...");
            int id = 0;

            while (true) {
                Socket socket = server.accept();
                id++;
                System.out.println("Client #" + id + " connected");

                ClientHandler ch = new ClientHandler(socket, id);
                ch.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

