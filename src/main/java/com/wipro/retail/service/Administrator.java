package com.wipro.retail.service;

import java.util.Date;
import java.util.List;

import com.wipro.retail.bean.RetailBean;
import com.wipro.retail.dao.RetailDAO;
import com.wipro.retail.util.InvalidInputException;

public class Administrator {

	RetailDAO d = new RetailDAO();

	public String addRecord(RetailBean bean) throws InvalidInputException {

		if (bean == null || bean.getCustomerName() == null || bean.getPurchaseDate() == null) {
			throw new InvalidInputException();
		}

		if (bean.getCustomerName().length() < 2) {
			return "INVALID CUSTOMER NAME";
		}

		if (bean.getQuantity() < 1 || bean.getPrice() <= 0) {
			return "INVALID ORDER DETAILS";
		}

		if (d.recordExists(bean.getCustomerName(), bean.getPurchaseDate()) == true) {
			return "ALREADY EXISTS";
		}

		String recordId = d.generateRecordID(bean.getCustomerName(), bean.getPurchaseDate());
		bean.setRecordId(recordId);

		return d.createRecord(bean);
	}

	public RetailBean viewRecord(String customerName, Date purchaseDate) {
		return d.fetchRecord(customerName, purchaseDate);
	}

	public List<RetailBean> viewAllRecords() {
		return d.fetchAllRecords();
	}
}
