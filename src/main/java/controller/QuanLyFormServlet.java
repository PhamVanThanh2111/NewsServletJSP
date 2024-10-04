package controller;

import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.TinTucDAO;
import daoimpl.TinTucDAOImpl;

/**
 * Servlet implementation class QuanLyFormServlet
 */
@WebServlet("/QuanLyFormServlet")
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TinTucDAO tinTucDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanLyFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		switch (action) {
		case "quanLy": {
			showQuanLy(request, response);
			break;
		}
		case "delete": {
			String id = request.getParameter("id");
			tinTucDAO.deleteTinTuc(Integer.parseInt(id));
			response.sendRedirect(request.getContextPath());
			break;
		}
		}
	}

	private void showQuanLy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getAttribute("tinTucList") == null) {
			request.setAttribute("tinTucList", tinTucDAO.getAllTinTuc());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/html/quanLyForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		tinTucDAO = new TinTucDAOImpl(Persistence.createEntityManagerFactory("tinTucPU"));
	}

}
