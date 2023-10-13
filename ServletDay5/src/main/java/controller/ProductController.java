package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Product;

public class ProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price"));
		String manufacturer = req.getParameter("manufacturer");
		String state = req.getParameter("state");

		Product product = new Product();
		product.setProductName(name);
		product.setProductBrand(brand);
		product.setProductManufacture(manufacturer);
		product.setState(state);

		if (state.equals("AP")) {
			ServletContext context = getServletContext();
			double CGST = Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config = getServletConfig();
			double SGST = Double.parseDouble(config.getInitParameter("AP"));
			double total_price = price + (CGST + SGST) * price;
			product.setProductPrice(total_price);
		} else {
			ServletContext context = getServletContext();
			double CGST = Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config = getServletConfig();
			double SGST = Double.parseDouble(config.getInitParameter("TS"));
			double total_price = price + (CGST + SGST) * price;
			product.setProductPrice(total_price);

		}

		ProductDao productDao = new ProductDao();
		productDao.saveBoth(product);

		PrintWriter printWriter = resp.getWriter();
		printWriter.print("valid successful");
	}
}
