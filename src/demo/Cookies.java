package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//This example will look at how one many want a user to stay signed into their website even after they have closed the browser so next time they come back on the website they are still logged in.
		//This is implicitly making use of cookies as users are becoming more and more aware of cookies being used explicitly.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
		//Setting cookies array
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null) {
			out.println("No cookies found<br/>");
		} else {
			
		//Looping through cookies
		for(Cookie retrievedCookie: cookies) {
			String name = retrievedCookie.getName();
			String value = retrievedCookie.getValue();
			
			out.println(name + "=" + value + "<br/>");
			
		}
		
	}
		//Setting new Cookie. Cookie Object has a name and a value.
		Cookie cookie = new Cookie("user", "Vicky");
		
		//Setting the cookie to last 300 secs (as an example). This will allow the cookie to persist for 5 minutes even if the browser has been exited.
		//By default life span of cookie is set to -1 meaning as soon as the browser is exited the cookie will be reset. 
		cookie.setMaxAge(300);
		
		response.addCookie(cookie);
		
		out.println("Cookie set.<br/>");
		out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
