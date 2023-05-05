package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/menushka?useUnicode=true&serverTimezone=UTC",
                    "root", "");
            System.out.println("connected");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Item> getAll(){
        ArrayList<Item> items = new ArrayList<Item>();

        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM menushka");
            ResultSet res = st.executeQuery();

            while(res.next()){
                long id = res.getLong("id");
                String name = res.getString("name");
                String description = res.getString("description");
                int price = res.getInt("price");
                String type = res.getString("type");

                items.add(new Item(id,name, description, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public void addItem(Item item){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO menushka VALUES (NULL,?,?,?,?)");

            st.setString(1,item.getName());
            st.setString(2, item.getDescription());
            st.setInt(3,item.getPrice());
            st.setString(4,"aziza bot");

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM menushka WHERE id = ?");
            st.setLong(1,id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
