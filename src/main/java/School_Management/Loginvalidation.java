package School_Management;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public final class Loginvalidation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email= req.getParameter("email");
		String password= req.getParameter("pass");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pranita");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select p from Principle p where p.email=?1 and p.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);

		List<Principle>principles = q.getResultList();
		if (principles.size() > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("Combine.html");
			rd.forward(req, resp);
		}

		else {
			//System.out.println("invalid credentials");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.forward(req, resp);
			
		}
	}
}
