package School_Management;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/goto")
public class PrincipleDriver extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mbilenumber = Long.parseLong(req.getParameter("mobilenumber"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pranita");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Principle p = new Principle();
		p.setName(name);
		p.setAge(age);
		p.setMobilenumber(mbilenumber);
		p.setEmail(email);
		p.setPassword(password);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
	}
	
}
