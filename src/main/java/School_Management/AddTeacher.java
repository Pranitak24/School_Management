package School_Management;

import java.io.IOException;

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

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;
@WebServlet("/happy1")
public class AddTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=req.getParameter("name");
		String salary=req.getParameter("sal");
		double salary1=Double.parseDouble(salary);
		String subject=req.getParameter("sub");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pranita");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t=new Teacher();
		t.setId(id1);
		t.setName(name);
		t.setSalary(salary1);
		t.setSubject(subject);
		
		
		et.begin();
		em.persist(t);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.forward(req, resp);
		
	}

}
