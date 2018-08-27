package com.scbeasy.demo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.scbeasy.demo.Bean.ScbeasyPriceBean;
import com.scbeasy.demo.DB.ConnectDB;


@Repository
public class KasikornServer {

	
	// krungsri_price
	public ScbeasyPriceBean checkpriceKa(String carYear, String carMake2) throws SQLException {
		ScbeasyPriceBean kabean = new ScbeasyPriceBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT * FROM scbeasy_price WHERE  ye_year= ? and br_name= ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, carYear);
			prepared.setString(2, carMake2);
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				kabean.setScPrice(rs.getInt("sc_price"));
				
			}
		} catch (Exception e) {

			// TODO: handle exception
		}
		finally {
			conn.close();
		}


		return kabean;
	}
}
