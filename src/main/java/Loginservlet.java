

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		FileReader fr = new FileReader("C:\\Users\\ABHI\\OneDrive\\Documents\\User.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] strArr = line.split(":");
		String storedEmail = strArr[0];
		String storedPwd = strArr[1];
		String responseMsg="";
		
		if( (email.equals(storedEmail)) && (pwd.equals(storedPwd))  ) {
			RequestDispatcher rd = request.getRequestDispatcher("/Homepage.html");
			rd.forward(request, response);
		} else {
			responseMsg = "Email and Password invalid";
		}
		String HTMLresponse="<html><body><h1>" + responseMsg +"</h1></body></html>";
		PrintWriter pw= response.getWriter();
		pw.write(HTMLresponse);
	
	}

}
