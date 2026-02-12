package com.wipro.retail.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.retail.bean.RetailBean;
import com.wipro.retail.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String operation = req.getParameter("operation");

		/* -------- ADD RETAIL TRANSACTION -------- */
		if (operation.equals("newRecord")) {

			String result = addRecord(req);

			if (result.equals("FAIL")) {
				resp.sendRedirect("error.html");
			} else {
				resp.sendRedirect("success.html");
			}
		}

		/* -------- VIEW SINGLE RETAIL TRANSACTION -------- */
		else if (operation.equals("viewRecord")) {

			RetailBean bean = viewRecord(req);

			if (bean == null) {
				req.setAttribute("message",
						"No matching records exists! Please try again!");
				RequestDispatcher rd =
						req.getRequestDispatcher("displayRetailTransaction.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("retailBean", bean);
				RequestDispatcher rd =
						req.getRequestDispatcher("displayRetailTransaction.jsp");
				rd.forward(req, resp);
			}
		}

		/* -------- VIEW ALL RETAIL TRANSACTIONS -------- */
		else if (operation.equals("viewAllRecords")) {

			List<RetailBean> list = viewAllRecords(req);

			if (list == null || list.isEmpty()) {
				req.setAttribute("message", "No records available!");
				RequestDispatcher rd =
						req.getRequestDispatcher("displayAllRetailTransactions.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("retailList", list);
				RequestDispatcher rd =
						req.getRequestDispatcher("displayAllRetailTransactions.jsp");
				rd.forward(req, resp);
			}
		}
	}

	/* ================= ADD RECORD ================= */
	public String addRecord(HttpServletRequest request) {

		try {
			RetailBean bean = new RetailBean();

			bean.setCustomerName(request.getParameter("customerName"));
			bean.setProductName(request.getParameter("productName"));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date purchaseDate = sdf.parse(request.getParameter("purchaseDate"));
			bean.setPurchaseDate(new java.sql.Date(purchaseDate.getTime()));

			bean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			bean.setPrice(Double.parseDouble(request.getParameter("price")));
			bean.setRemarks(request.getParameter("remarks"));

			// Call service
			try {
			    return new Administrator().addRecord(bean);
			} catch (Exception e) {
			    return "FAIL";
			}


		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
	}

	/* ================= VIEW SINGLE RECORD ================= */
	public RetailBean viewRecord(HttpServletRequest request) {

		try {
			String customerName = request.getParameter("customerName");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date purchaseDate = sdf.parse(request.getParameter("purchaseDate"));

			return new Administrator().viewRecord(customerName, purchaseDate);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* ================= VIEW ALL RECORDS ================= */
	public List<RetailBean> viewAllRecords(HttpServletRequest request) {

		return new Administrator().viewAllRecords();
	}
}
