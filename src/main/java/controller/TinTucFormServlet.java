package controller;

import java.io.IOException;
import java.util.Set;

import dao.DanhMucDAO;
import dao.TinTucDAO;
import daoimpl.DanhMucDAOImpl;
import daoimpl.TinTucDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import model.TinTuc;

/**
 * Servlet implementation class TinTucFormServlet
 */
@WebServlet("/TinTucFormServlet")
public class TinTucFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DanhMucDAO danhMucDAO;
	private TinTucDAO tinTucDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TinTucFormServlet() {
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
		case "showAddForm": {
			showAddForm(request, response);
			break;
		}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		switch (action) {
		case "add": {
			addTinTuc(request, response);
			break;
		}
		}
	}
	
	private void addTinTuc(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String tieuDe = request.getParameter("tieuDe");
		String noiDung = request.getParameter("noiDung");
		String lienKet = request.getParameter("lienKet");
		String maDanhMuc = request.getParameter("category");
		
		TinTuc tinTuc = new TinTuc(tieuDe, noiDung, lienKet, Integer.parseInt(maDanhMuc));
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<TinTuc>> violations = validator.validate(tinTuc);
		
		if (violations.isEmpty()) {
	        tinTucDAO.addTinTuc(tinTuc);
	        response.sendRedirect(request.getContextPath());
        }
		else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/tinTucForm.jsp");
            
            StringBuilder stringBuilder = new StringBuilder();
            violations.forEach(violation -> {
            	stringBuilder.append(violation.getPropertyPath() + ": " + violation.getMessage());
            });
            
            request.setAttribute("errors", stringBuilder);
            dispatcher.forward(request, response);
        }
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tinTucPU");
		danhMucDAO = new DanhMucDAOImpl(entityManagerFactory);
		tinTucDAO = new TinTucDAOImpl(entityManagerFactory);
	}
	
	private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getAttribute("categoryList") == null) {
			request.setAttribute("categoryList", danhMucDAO.getAllDanhMuc());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/html/tinTucForm.jsp");
		dispatcher.forward(request, response);
	}

}
