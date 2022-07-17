package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Stock;



public class DbConnection {
	
	public Connection connection;
	public PreparedStatement statement;
	
	public static String url = "jdbc:mysql://localhost/stok";
	public static String username = "root";
	public static String password = "";
	
	public List<Stock> Stocks;
	
	public DbConnection() {
		Stocks = new ArrayList<>();
	}
    
	public Connection getConnection() {
		try {
			if(connection == null) {
				connection = DriverManager.getConnection(url,username,password);
			}
			
		}catch (Exception ex){
			
		}
		return connection;
	}
	/*
	
	public void save (Stock stock) {
		try {
			
			statement =  getConnection().prepareStatement("select StokKodu from stokkart1 where StokKodu=?");
			statement.setString(1, stock.getStokKodu()); 
			ResultSet rs =statement.executeQuery();
			statement =  getConnection().prepareStatement("insert into stokkart1 values(?,?,?,?,?,?,?,?)");
			
			if(rs.next()) {
				statement =  getConnection().prepareStatement("insert into stokkart1 values(?,?,?,?,?,?,?,?)");
				stock.setStokKodu(stock.getStokKodu());
			}
			statement.setString(1, stock.getStokKodu());
			statement.setString(2, stock.getStokAdi());
			statement.setInt(3, stock.getStokTipi());
			statement.setString(4, stock.getBirim());
			statement.setString(5, stock.getBarkod());
			statement.setDouble(6, stock.getKDVTipi());
			statement.setString(7, stock.getAciklama());
			statement.setString(8, stock.getTarih());
			statement.executeUpdate();
			//getConnection().close();
			
		}catch (Exception ex){
			
		}
	}
	
	public void update (Stock stock) {
		try {
			statement =  getConnection().prepareStatement("update stokkart1 set StokAdi=?, StokTipi=?, Birim=?, Barkod=?, KDVTipi=?, Aciklama=?, Tarih=? where StokKodu=?");
			statement.setString(1, stock.getStokAdi());
			statement.setInt(2, stock.getStokTipi());
			statement.setString(3, stock.getBirim());
			statement.setString(4, stock.getBarkod());
			statement.setDouble(5, stock.getKDVTipi());
			statement.setString(6, stock.getAciklama());
			statement.setString(7,  stock.getTarih());
			statement.setString(8, stock.getStokKodu());
			statement.executeUpdate();
			//getConnection().close();
		}catch (Exception ex){
			
		}
	}
	
	public void delete (Stock stock) {
		try {
			statement =  getConnection().prepareStatement("delete from stokkart1 where StokKodu=?");
			statement.setString(1, stock.getStokKodu());
			statement.executeUpdate();
			//getConnection().close();
		}catch (Exception ex){
			
		}
	}
	
public List<Stock> getStocks(String Stok_Kodu) {
		
		try {
			
			if (Stok_Kodu !=null) {
				statement =  getConnection().prepareStatement("select StokKodu,StokAdi,StokTipi,Birim,Barkod,KDVTipi,Aciklama,Tarih from stokkart1 where StokKodu=?");
				statement.setString(1, Stok_Kodu);
				//statement.setString(2, Stok_Kodu);
			}
			else {
				statement =  getConnection().prepareStatement("select * from stokkart1");
			}
			
			
			ResultSet rs =statement.executeQuery();
			List<Stock> stocks = new ArrayList<>();
			while(rs.next()) {
				Stock stock = new Stock();
				stock.setStokKodu(rs.getString("StokKodu"));
				//stock.setStokKodu(rs.getString("StokKodu"));
				stock.setStokAdi(rs.getString("StokAdi"));
				stock.setStokTipi(rs.getInt("StokTipi"));
				stock.setBirim(rs.getString("Birim"));
				stock.setBarkod(rs.getString("Barkod"));
				stock.setKDVTipi(rs.getDouble("KDVTipi"));
				stock.setAciklama(rs.getString("Aciklama"));
				stock.setTarih(rs.getString("Tarih"));
				stocks.add(stock);
			}
			return stocks;
		}catch (Exception ex){
			
		}
		return new ArrayList<>();
		
	}*/
}
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	

