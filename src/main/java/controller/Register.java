package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import repository.UserRepository;
import service.UserService;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Register.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (UserRepository userRepository = new UserRepository()) {
			
			UserService userService = new UserService(userRepository);
			Map<String, String> errors = userService.register(user);
			if (errors.isEmpty()) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				request.setAttribute("user", user);
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
		}
		
	}

}