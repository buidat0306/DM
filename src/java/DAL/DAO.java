/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Human;
import model.HumanType;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Acer
 */
public class DAO extends DBcontext{
    public static DAO INSTANCE= new DAO();
    private Connection con;
    private String status = "OK";
    
    public DAO(){
        if(INSTANCE==null){
            con = new DBcontext().connect;
        }else 
            INSTANCE = this;
    }
    public void loadDB(){
        System.out.println("Loading data...");

    }
    public List<Human> getAllHumans() {
        List<Human> humans = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM Human INNER JOIN HumanType ON Human.typeid = HumanType.typeid";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Human human = new Human();
                    human.setHumanid(resultSet.getInt("humanid"));
                    human.setHumanname(resultSet.getString("humanname"));
                    human.setHumandob(resultSet.getString("humandob"));
                    human.setHumangender(resultSet.getString("humangender"));

                    HumanType humanType = new HumanType();
                    humanType.setTypeid(resultSet.getInt("typeid"));
                    humanType.setTypename(resultSet.getString("typename"));

                    human.setType(humanType);

                    humans.add(human);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return humans;
    }

    public List<Human> searchHumans(String keyword) {
        // Implement search logic based on the keyword
        // You can modify the SQL query accordingly
        List<Human> searchResults = new ArrayList<>();
        // Example SQL: "SELECT * FROM Human WHERE humanname LIKE ?"
        return searchResults;
    }

    public void insertHuman(Human human) {
        // Implement insert logic
        // Example SQL: "INSERT INTO Human (humanname, humandob, humangender, typeid) VALUES (?, ?, ?, ?)"
         try (Connection connection = getConnection()) {
            String sql = "INSERT INTO Human (humanname, humandob, humangender, typeid) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, human.getHumanname());
                statement.setString(2, human.getHumandob());
                statement.setString(3, human.getHumangender());
                statement.setInt(4, human.getTypeid());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHuman(Human human) {
        // Implement update logic
        // Example SQL: "UPDATE Human SET humanname=?, humandob=?, humangender=?, typeid=? WHERE humanid=?"
        try (Connection connection = getConnection()) {
            String sql = "UPDATE Human SET humanname=?, humandob=?, humangender=?, typeid=? WHERE humanid=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, human.getHumanname());
                statement.setString(2, human.getHumandob());
                statement.setString(3, human.getHumangender());
                statement.setInt(4, human.getTypeid());
                statement.setInt(5, human.getHumanid());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHuman(int humanId) {
        // Implement delete logic
        // Example SQL: "DELETE FROM Human WHERE humanid=?"
    
         try (Connection connection = getConnection()) {
            String sql = "DELETE FROM Human WHERE humanid=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, humanId);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
