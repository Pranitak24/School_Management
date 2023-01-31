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
@WebServlet("/ert1")
public class UpdateStudent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String fees=req.getParameter("fees");
		double fees1=Double.parseDouble(fees);
		
		Student s=new Student();
		s.setId(id1);
		s.setName(name);
        s.setStream(stream);
        s.setFees(fees1);
        HttpSession h= req.getSession();
		h.setAttribute("abc2", s);
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("pranita");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        
        et.begin();
        em.merge(s);        
        et.commit();
        
        RequestDispatcher rd=req.getRequestDispatcher("UpdateStudent.jsp");
        rd.forward(req, resp);
        		
        
	}

}
