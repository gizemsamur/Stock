package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import controller.DbConnection;

public class Stock extends BaseModel {

	// public PreparedStatement statement;
	public List<Stock> Stocks;
	private String StokKodu;
	private String StokAdi;
	private String StokTipi;
	private String Birim;
	private String Barkod;
	private double KDVTipi;
	private String Aciklama;
	private String Tarih;

	public String getStokKodu() {
		return StokKodu;
	}

	public void setStokKodu(String stokKodu) {
		StokKodu = stokKodu;
	}

	public String getStokAdi() {
		return StokAdi;
	}

	public void setStokAdi(String stokAdi) {
		StokAdi = stokAdi;
	}

	public String getStokTipi() {
		return StokTipi;
	}

	public void setStokTipi(String stokTipi) {
		StokTipi = stokTipi;
	}

	public String getBirim() {
		return Birim;
	}

	public void setBirim(String birim) {
		Birim = birim;
	}

	public String getBarkod() {
		return Barkod;
	}

	public void setBarkod(String barkod) {
		Barkod = barkod;
	}

	public double getKDVTipi() {
		return KDVTipi;
	}

	public void setKDVTipi(double kDVTipi) {
		KDVTipi = kDVTipi;
	}

	public String getAciklama() {
		return Aciklama;
	}

	public void setAciklama(String aciklama) {
		Aciklama = aciklama;
	}

	public String getTarih() {
		return Tarih;
	}

	public void setTarih(String tarih) {
		Tarih = tarih;
	}

	public void save(Stock stock) {
		// insert

		try {

			PreparedStatement statement;
			Connection connection = (Connection) getConnection();
			statement = ((Connection) getConnection()).prepareStatement("select StokKodu from stokkart1 where StokKodu=?");
			statement.setString(1, stock.getStokKodu());
			ResultSet rs = statement.executeQuery();
			statement = ((Connection) getConnection()).prepareStatement("insert into stokkart1 values(?,?,?,?,?,?,?,?)");

			if (rs.next()) {
				statement = ((Connection) getConnection()).prepareStatement("insert into stokkart1 values(?,?,?,?,?,?,?,?)");
				stock.setStokKodu(stock.getStokKodu());
			}
			statement.setString(1, stock.getStokKodu());
			statement.setString(2, stock.getStokAdi());
			statement.setString(3, stock.getStokTipi());
			statement.setString(4, stock.getBirim());
			statement.setString(5, stock.getBarkod());
			statement.setDouble(6, stock.getKDVTipi());
			statement.setString(7, stock.getAciklama());
			statement.setString(8, stock.getTarih());
			statement.executeUpdate();
			// getConnection().close();

		} catch (Exception ex) {

		}
	}

	public void update(Stock stock) {
		// update

		try {
			PreparedStatement statement;
			Connection connection = (Connection) getConnection();
			statement = ((Connection) getConnection()).prepareStatement(
					"update stokkart1 set StokAdi=?, StokTipi=?, Birim=?, Barkod=?, KDVTipi=?, Aciklama=?, Tarih=? where StokKodu=?");
			statement.setString(1, stock.getStokAdi());
			statement.setString(2, stock.getStokTipi());
			statement.setString(3, stock.getBirim());
			statement.setString(4, stock.getBarkod());
			statement.setDouble(5, stock.getKDVTipi());
			statement.setString(6, stock.getAciklama());
			statement.setString(7, stock.getTarih());
			statement.setString(8, stock.getStokKodu());
			statement.executeUpdate();
			// getConnection().close();
		} catch (Exception ex) {

		}
	}

	public void delete(Stock stock) {
		try {
			PreparedStatement statement;
			Connection connection = (Connection) getConnection();
			statement = ((Connection) getConnection()).prepareStatement("delete from stokkart1 where StokKodu=?");
			statement.setString(1, stock.getStokKodu());
			statement.executeUpdate();
			// getConnection().close();
		} catch (Exception ex) {

		}

	}

	public List<Stock> getStocks(String Stok_Kodu) {

		try {
			PreparedStatement statement;
			Connection connection = getConnection();

			if (Stok_Kodu != null) {
				statement = ((Connection) getConnection()).prepareStatement(
						"select StokAdi,StokTipi,Birim,Barkod,KDVTipi,Aciklama,Tarih from stokkart1 where StokKodu=?");
				statement.setString(1, Stok_Kodu);
			    //statement.setString(2, Stok_Kodu);
			} else {
				statement = ((Connection) getConnection()).prepareStatement("select * from stokkart1");
			}

			ResultSet rs = statement.executeQuery();
			List<Stock> stocks = new ArrayList<>();
			while (rs.next()) {
				Stock stock = new Stock();
				stock.setStokKodu(rs.getString("StokKodu"));
				//stock.setStokKodu(rs.getString("StokKodu"));
				stock.setStokAdi(rs.getString("StokAdi"));
				stock.setStokTipi(rs.getString("StokTipi"));
				stock.setBirim(rs.getString("Birim"));
				stock.setBarkod(rs.getString("Barkod"));
				stock.setKDVTipi(rs.getDouble("KDVTipi"));
				stock.setAciklama(rs.getString("Aciklama"));
				stock.setTarih(rs.getString("Tarih"));
				stocks.add(stock);
			}
			return stocks;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();

	}

}
