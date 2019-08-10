package com.accolite.au;

import java.sql.Timestamp;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
	
	@RequestMapping("/app")
	public String login(Model m) {
		return "welcome";
	}
	
	@RequestMapping("/signup")
	public String SignUpUser(HttpServletRequest req,Model m)
	{
		Utility utility=new Utility();
		Session session=utility.getsession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		username=username.trim();
		password=password.trim();
		
		Transaction tx=session.beginTransaction();
		
		String hql="from User u where u.username=:username";
		Query query=session.createQuery(hql);
		query.setParameter("username", username);
		User user=(com.accolite.au.User) query.uniqueResult();
		
		tx.commit();
		if(user!=null)
		{
			String message="User Exist";
			m.addAttribute("message", message);
			return "welcome";
		}
		
		if(user==null)
		{
			Transaction tx1=session.beginTransaction();

			Timestamp ts=new Timestamp(new Date().getTime());
			User user1=new User(username,password,0,ts,false);
			session.save(user1);
			tx1.commit();
		}
		session.close();
		return "login";
	}

}


