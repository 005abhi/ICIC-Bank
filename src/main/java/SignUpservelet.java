

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpservelet
 */
public class SignUpservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUpservelet() {
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
		String confirmPwd = request.getParameter("cpwd");
		String balance = request.getParameter("bal");
				
		String email = request.getParameter("email");
		String responseMsg = "";
		
		if(pwd.equals(confirmPwd)) {
			// Write email and pwd inside file
			FileWriter fw = new FileWriter("C:\\Users\\ABHI\\OneDrive\\Documents\\User.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(email+":"+pwd);
			bw.close();
			FileWriter fw2 = new FileWriter("C:\\Users\\ABHI\\OneDrive\\Documents\\balance.txt");
			BufferedWriter bw2 = new BufferedWriter(fw2);
			bw2.write(balance);
			bw2.close();
			
			responseMsg = "Sign Up success";
		} else {
			responseMsg = "password mismatch";
		}
		String HTMresponsee="<button><a href=\"index.html\">login</a></button>";
		String responseHtml = "<html><body><h1>" + responseMsg +"</h1></body></html>";
		PrintWriter pw= response.getWriter();
		pw.write(responseHtml);
		pw.write(HTMresponsee);
	}

}
