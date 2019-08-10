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
public class SignInController {
	
	@RequestMapping("/helper")
	public String redirect(Model m)
	{
		return "login";
	}
	@RequestMapping("/unblock")
	public String adminfunction(HttpServletRequest req,Model m)
	{
		Utility utility=new Utility();
		Session session=utility.getsession();
		Transaction tx=session.beginTransaction();
		String username = req.getParameter("username");
		String hql="update User set checked=:value where username=:username";
		(session.createQuery(hql).setParameter("value", false).setParameter("username", username)).executeUpdate();
		tx.commit();
		return "admin";
		
		
	}
	
	@RequestMapping("/signin")
	public String SignInUser(HttpServletRequest req,Model m)
	{
		Utility utility=new Utility();
		Session session=utility.getsession();
		Transaction tx=session.beginTransaction();

		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		username =username.trim();
		password= password.trim();
		
		if("admin".equals(username)&&"admin".equals(password))
		{
			Query query5=session.createQuery("from User");
			return "admin";
		}
		
		String hql="From User u where u.username=:username";
		Query query=session.createQuery(hql);
		query.setParameter("username", username);
		
		User user=(com.accolite.au.User) query.uniqueResult();
		
		if(user==null)
		{
			String invalid="Login Failed ! You don't have an account";
			m.addAttribute("invalid", invalid);
			return "welcome";
		}
		
		if(user.isChecked())
		{
			String account_blocked="Your account is permanently blocked";
			m.addAttribute("account_blocked", account_blocked);
			return "login";
		}
		
		if(user.getPassword().compareTo(password)==0)
		{
			Query query1=session.createQuery("update User u set u.count=0 where u.username=:username");
			query1.setParameter("username", username);
			query1.executeUpdate();
			if(new Timestamp(new Date().getTime()).compareTo(user.getTs())<0)
			{
				Integer timestamp=user.getTs().getMinutes()-new Date().getMinutes();
				String tryagain="Try again after "+timestamp.toString()+ " minutes";
				m.addAttribute("tryagain",tryagain);
				tx.commit();
				return "login";
			}
			else 
			{
				String ucase=username.toUpperCase();
				m.addAttribute("ucase", ucase);
				tx.commit();
				return "success";
			}
		}
		else
		{
			int count =user.getCount()+1;
			Query query2=session.createQuery("update User u set u.count=:count where u.username=:username");
			query2.setParameter("count", count);
			query2.setParameter("username", username);
			query2.executeUpdate();
			if(count==10)
			{
				boolean checked=true;
				Query query3=session.createQuery("update User u set u.checked=:checked where u.username=:username");
				query3.setParameter("checked", checked);
				query3.setParameter("username", username);
				query3.executeUpdate();
				tx.commit();
				String account_blocked="Your account is permanently blocked";
				m.addAttribute("account_blocked", account_blocked);
				return "login";
			}
			if (count % 3==0)
			{
				int multiplier=1;
				for(int i=1;i<count/3;i++)
				{
					multiplier=multiplier*2;
				}
				Timestamp ts=new Timestamp(new Date().getTime()+multiplier*300000);
				Query query4=session.createQuery("update User u set u.ts=:ts where u.username=:username");
				query4.setParameter("ts", ts);
				query4.setParameter("username", username);
				query4.executeUpdate();
				tx.commit();
				Integer time=multiplier*5;
				String block="Wrong password! Your account is blocked for "+time.toString()+" minutes";
				m.addAttribute("block", block);
				return "login";
			}
			else
			{
				System.out.println(count);
				tx.commit();
				String wrong="Wrong password ! Try again";
				m.addAttribute("wrong", wrong);
				return "login";
			}
			
		}
		
	}

}
