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
import javax.servlet.http.HttpSession;
@WebServlet("/stud")
public class ReadStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
				int id= Integer.parseInt(req.getParameter("id"));
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("pranita");
				EntityManager em=emf.createEntityManager();
				EntityTransaction et=em.getTransaction();
				
				Student s=em.find(Student.class,id);
				HttpSession h= req.getSession();
				h.setAttribute("abc", s);
				
				RequestDispatcher rd= req.getRequestDispatcher("ReadStudent.jsp")		;
				rd.forward(req, resp);
			}

		

	}


