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
@WebServlet("/teach")
public class Read extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pranita");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t=em.find(Teacher.class, id);
		HttpSession h=req.getSession();
		h.setAttribute("abc1",t);
		
		
		RequestDispatcher rd=req.getRequestDispatcher("ReadTeacher.jsp");
		rd.forward(req, resp);
		
		
		
	}


}
