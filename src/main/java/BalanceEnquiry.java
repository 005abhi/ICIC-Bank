

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BalanceEnquiry
 */
public class BalanceEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceEnquiry() {
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
	 */protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pwd = request.getParameter("pwd");
			FileReader fr = new FileReader("C:\\Users\\ABHI\\OneDrive\\Documents\\User.txt");
			BufferedReader br = new BufferedReader(fr);
			String Line = br.readLine();
			String[] strArr = Line.split(":");
			String storedPwd = strArr[1];
			String resultMsg = "";
			if (pwd.equals(storedPwd)) {
				FileReader fr2 = new FileReader("C:\\Users\\ABHI\\OneDrive\\Documents\\balance.txt");
				BufferedReader br2 = new BufferedReader(fr2);
				String AvaiBal = br2.readLine();
				resultMsg = "Available Balance: "+AvaiBal;
			} else {
				resultMsg = "Incorrect Password. Please enter the correct password";
			}
			String HTMresponsee="<button><a href=\"Homepage.html\">home</a></button>";

			String Htmlresult = "<html><body><h1>"+resultMsg +"</h1></body></html>";
			PrintWriter pw = response.getWriter();
			pw.write(Htmlresult);
			pw.write(HTMresponsee);
		}

	}
