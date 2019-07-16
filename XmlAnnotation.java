package com.accolite.au.assignments;
import java.io.FileWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Servlet {
	String name();
	String url();
}
@Servlet(name = "AnnotationExample", url = "AnnotationExampleServlet")
public class XmlAnnotation {
	public XmlAnnotation() {
		Servlet Annotation = this.getClass().getAnnotation(Servlet.class);
		try 
		{
			FileWriter fw = new FileWriter("C:\\Users\\kunal.juneja\\Documents\\servlet.xml");
			fw.write("<servlet>\n");
			fw.write("\t<servletname>" + Annotation.name() + "</servletname>\n");
			fw.write("\t<url>" + Annotation.url() + "</url>\n");
			fw.write("\t<class>" + this.getClass().getSimpleName() + "</class>\n");
			fw.write("</servlet>\n");
			fw.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		XmlAnnotation XmlAnnotationObj = new XmlAnnotation();
	}
}
