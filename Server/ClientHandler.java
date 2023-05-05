package Server;

import core.DBManager;
import core.Item;
import core.PackageData;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;
    DBManager db = new DBManager();

    public ClientHandler(Socket socket, int id){
        this.db.connect();
        this.socket = socket;
        this.id = id;
    }

    public void run(){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData requestData;
            while(!socket.isClosed() && (requestData = (PackageData) inputStream.readObject()) != null){
                System.out.printf("Client #%s sent %s request%n", id, requestData.getOperationType());

                switch (requestData.getOperationType()){
                    case ADD:
                        db.addItem(requestData.getItem());
                        break;

                    case LIST:
                        ArrayList<Item> items = (ArrayList<Item>) db.getAll();
                        PackageData responseData = new PackageData();
                        responseData.setItems(items);
                        outputStream.writeObject(responseData);
                        break;

                    case DELETE:
                        db.deleteItem(requestData.getId());
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
