package com.wipro.retail.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wipro.retail.bean.RetailBean;
import com.wipro.retail.util.DBUtil;

public class RetailDAO {
	public String createRecord(RetailBean bean) {
		Connection con= DBUtil.getDBConnection();
		String query =
				"INSERT INTO RETAIL_TB (RECORDID, CUSTOMERNAME, PRODUCTNAME, PURCHASE_DATE, QUANTITY, PRICE, REMARKS) " +
				"VALUES (?,?,?,?,?,?,?)";
	
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, bean.getRecordId());
			ps.setString(2, bean.getCustomerName());
			ps.setString(3, bean.getProductName());
			ps.setDate(4, new java.sql.Date(bean.getPurchaseDate().getTime()));
			ps.setInt(5, bean.getQuantity());
			ps.setDouble(6, bean.getPrice());
			ps.setString(7, bean.getRemarks());
			int rows=ps.executeUpdate();
			if(rows>0) {
				return bean.getRecordId();
			}
			return "FAIL";
		}catch(Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
	
	public RetailBean fetchRecord(String customerName, Date purchaseDate) {
		
		Connection con=DBUtil.getDBConnection();
		String query="SELECT * FROM RETAIL_TB WHERE CUSTOMERNAME=? AND PURCHASE_DATE=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, customerName);
			ps.setDate(2, new java.sql.Date(purchaseDate.getTime()));
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				RetailBean r=new RetailBean();
				r.setRecordId(rs.getString(1));
				r.setCustomerName(rs.getString(2));
				r.setProductName(rs.getString(3));
				r.setPurchaseDate(rs.getDate(4));
				r.setQuantity(rs.getInt(5));
				r.setPrice(rs.getDouble(6));
				r.setRemarks(rs.getString(7));				
				return r;
			}
			return null;
					
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
	public String generateRecordID(String customerName, Date purchaseDate) {

		String recordId = "";

		try {
			DateFormat f = new SimpleDateFormat("yyyyMMdd");
			String datePart = f.format(purchaseDate);

			String namePart = customerName.substring(0, 2).toUpperCase();

			Connection con = DBUtil.getDBConnection();
			String query = "SELECT COUNT(*) FROM RETAIL_TB WHERE CUSTOMERNAME=? AND PURCHASE_DATE=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerName);
			ps.setDate(2, new java.sql.Date(purchaseDate.getTime()));

			ResultSet rs = ps.executeQuery();

			int seq = 1;
			if (rs.next()) {
				seq = rs.getInt(1) + 1;
			}

			recordId = datePart + namePart + seq;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return recordId;
	}

	
	public boolean recordExists(String customerName, Date purchaseDate) {
		
		Connection con = DBUtil.getDBConnection();
		String query="SELECT * FROM RETAIL_TB WHERE CUSTOMERNAME=? AND PURCHASE_DATE=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, customerName);
			ps.setDate(2, new java.sql.Date(purchaseDate.getTime()));
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<RetailBean> fetchAllRecords(){
		
		Connection con=DBUtil.getDBConnection();
		String query="SELECT * FROM RETAIL_TB";
		List<RetailBean> list =new ArrayList<>();
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RetailBean r=new RetailBean();
				r.setRecordId(rs.getString(1));
				r.setCustomerName(rs.getString(2));
				r.setProductName(rs.getString(3));
				r.setPurchaseDate(rs.getDate(4));
				r.setQuantity(rs.getInt(5));
				r.setPrice(rs.getDouble(6));
				r.setRemarks(rs.getString(7));				
				list.add(r);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return list;
		}
	}
}
