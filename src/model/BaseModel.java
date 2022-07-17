package model;

import java.sql.Connection;

import controller.DbConnection;

public abstract class BaseModel {
	
	
	DbConnection connection;
	
	public BaseModel() {
		connection = new DbConnection();
	}
	
	
	public Connection getConnection() {
		return connection.getConnection();
	}
	

}
