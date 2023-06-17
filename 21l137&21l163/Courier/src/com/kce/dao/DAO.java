package com.kce.dao;

import java.sql.*;
import com.kce.bean.courier;
import com.kce.service.DBConnection;

public class DAO {
 private Connection connection;
 private PreparedStatement statement;


 public void disconnect() throws SQLException {
 if (statement != null) {
 statement.close();
 }
 if (connection != null) {
 connection.close();
 }
 }
 public void createCourier(courier courier) throws SQLException {
 String sql = "INSERT INTO courier (id, name) VALUES (?, ?)";
 Connection connection = DBConnection.createConnection();
 statement = connection.prepareStatement(sql);
 statement.setInt(1, courier.getId());
 statement.setString(2, courier.getName());
 statement.executeUpdate();
 }

 // Read a courier entity by ID
 public courier readCourier(int id) throws SQLException {
 String sql = "SELECT * FROM courier WHERE id = ?";
 Connection connection = DBConnection.createConnection();
 statement = connection.prepareStatement(sql);
 statement.setInt(1, id);
 ResultSet resultSet = statement.executeQuery();
 if (resultSet.next()) {
 courier Courier = new courier();
 Courier.setId(resultSet.getInt("id"));
 Courier.setName(resultSet.getString("name"));
 return Courier;
 }
 return null;
 }
 public void updateCourier(courier Courier) throws SQLException {
 String sql = "UPDATE courier SET name = ? WHERE id = ?";
 Connection connection = DBConnection.createConnection();
 statement = connection.prepareStatement(sql);
 statement.setString(1, Courier.getName());
 statement.setInt(2, Courier.getId());
 statement.executeUpdate();
 }
 public void deleteCourier(int id) throws SQLException {
 String sql = "DELETE FROM courier WHERE id = ?";
 Connection connection = DBConnection.createConnection();
 statement = connection.prepareStatement(sql);
 statement.setInt(1, id);
 statement.executeUpdate();
 }
}