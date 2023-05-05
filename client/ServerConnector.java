package client;

import core.Item;
import core.PackageData;
import emuns.CommandEnum;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnector {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public ServerConnector(Socket socket) {
        try {
            this.socket = socket;
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addItem(Item item){
        try{
            PackageData requestData = new PackageData(CommandEnum.ADD, item);
            outputStream.writeObject(requestData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Item> listItems(){
        try{
            PackageData requestData = new PackageData(CommandEnum.LIST);
            outputStream.writeObject(requestData);

            PackageData responseData;
            while((responseData = (PackageData) inputStream.readObject()) != null){
                return responseData.getItems();
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void deleteItem(long id){
        try{
            PackageData requestData = new PackageData(CommandEnum.DELETE, id);
            outputStream.writeObject(requestData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSocket(){
        try {
            PackageData requestData = new PackageData(CommandEnum.EXIT);
            outputStream.writeObject(requestData);

            this.inputStream.close();
            this.outputStream.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
