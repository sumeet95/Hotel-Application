/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

import room.Room;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Andre
 */
public class DataBase {

    private Connection connection;
    Statement statement;
    ResultSet rs;
    ArrayList results;
    int count = 0;

    public DataBase() {
    }

    public void connect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();

            connection = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "N01008689", "oracle");
            System.out.println("Connection success!");

        } catch (Exception e) {

            System.out.println("Connection failed!");
        }
    }

    public void bookRooms(String id, String userid) {
        insert("INSERT INTO ROOMBOOKED (roomid , userid) VALUES (" + id + "," + userid + ")");
        insert("UPDATE ROOMS set status=1 where roomid=" + id);

    }

    public int validate(String query) {
        int i = 0;

        try {

            statement = connection.createStatement();

            if (rs.next()) {
                while (rs.next()) {
                    i = rs.getInt("USERID");
                    return i;
                }
            } else {
                return 0;
            }

        } catch (Exception e) {
        }

        return i;
    }

    public ArrayList selectRooms(String query) {
        results = new ArrayList();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                results.add(rs.getString("ROOMID"));
                results.add(rs.getString("NAME"));
                results.add(rs.getString("LOCATION"));
                results.add(rs.getString("STATUS"));
            }

        } catch (Exception e) {

        }
        return results;
    }

    public ArrayList select(String query, String s) {
        results = new ArrayList();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                results.add(rs.getString("USERID"));
                results.add(rs.getString("TYPE"));
                results.add(rs.getString("NAME"));
            }

        } catch (Exception e) {

        }
        return results;
    }

    public int insert(String s) {
        int result;

        try {
            statement = connection.createStatement();
            count = statement.executeUpdate(s);
            result = 0;

        } catch (SQLException e) {
            result = 1;
        }

        return result;
    }

    public void insertBookRoom(int roomNum, String username, String userneeds, String checkin, String checkout) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BOOKEDROOMS VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, roomNum);
            preparedStatement.setString(2, username);
            preparedStatement.setString(4, checkin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void insertItems() {
    }

    public void update() {
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {

        }
    }

    public int delete(String s) {
        try {
            statement = connection.createStatement();
            count = statement.executeUpdate("DELETE FROM ROOMS WHERE ROOMID = " + s);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public ArrayList<Room> selectAllRooms(String type) {
//        results = new ArrayList();
        ArrayList<Room> rooms = new ArrayList<Room>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * from ROOMS WHERE status = 0 AND roomtype='" + type + "';");

            while (rs.next()) {
                rooms.add(new Room(rs.getInt("ROOMID"),
                        rs.getString("NAME"),
                        rs.getString("LOCATION"),
                        rs.getString("DESCRIPTION"),
                        rs.getInt("STATUS"),
                        rs.getString("ROOMTYPE")));
            }

        } catch (Exception e) {

        }
        return rooms;
    }

    public ArrayList<Room> selectMyRooms(String id) {
//        results = new ArrayList();
        ArrayList<Room> rooms = new ArrayList<Room>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT r.roomid, r.name, r.location, r.description, r.roomtype FROM rooms r INNER JOIN roombooked rb ON r.roomid = rb.roomid WHERE rb.userid='"+id+"'");
          
            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("ROOMID"),
                        rs.getString("NAME"),
                        rs.getString("LOCATION"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("ROOMTYPE")
                        ));
            }

        } catch (Exception e) {

        }
        return rooms;
    }

    public ArrayList<Room> selectAllRooms() {
//        results = new ArrayList();
        ArrayList<Room> rooms = new ArrayList<Room>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * from ROOMS");

            while (rs.next()) {
                rooms.add(new Room(rs.getInt("ROOMID"),
                        rs.getString("NAME"),
                        rs.getString("LOCATION"),
                        rs.getString("DESCRIPTION"),
                        rs.getInt("STATUS"),
                        rs.getString("ROOMTYPE")));
            }

        } catch (Exception e) {

        }
        return rooms;
    }

}
