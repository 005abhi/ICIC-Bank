

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Checkpasswordservlet
 */
public class Checkpasswordservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkpasswordservlet() {
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
		String pwd = request.getParameter("pwd");
		String npwd = request.getParameter("npwd");
		String cpwd = request.getParameter("cpwd");
		FileReader fr = new FileReader("C:\\Users\\ABHI\\OneDrive\\Documents\\User.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] strArr = line.split(":");
		String storedEmail = strArr[0];
		String storedPwd = strArr[1];
		String respondMsg ="";
		if (!pwd.equals(storedPwd)) {
			respondMsg = "password Mismatch, please enter the correct password"	;
		} else {
			if (!pwd.equals(npwd) && npwd.equals(cpwd)) {
				respondMsg = "password changed seccesfully";
				FileWriter fw = new FileWriter("C:\\Users\\ABHI\\OneDrive\\Documents\\User.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(storedEmail+":"+npwd);
				bw.close();
				
		} else {
			respondMsg = "Password and New password must be different";
		}
		}
		String HTMresponsee="<button><a href=\"Homepage.html\">home</a></button>";
			String HTMLresponse="<html><body><h1>" + respondMsg +"</h1></body></html>";
			PrintWriter pw= response.getWriter();
			pw.write(HTMLresponse);
			pw.write(HTMresponsee);
	

	}
}
