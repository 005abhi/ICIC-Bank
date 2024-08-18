

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Withdrawservlet
 */
public class Withdrawservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdrawservlet() {
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
		String amount = request.getParameter("withdrawAmt");
		int withdrawAmount = Integer.parseInt(amount);
		FileReader fr = new FileReader("C:\\Users\\ABHI\\OneDrive\\Documents\\User.txt");
		BufferedReader br = new BufferedReader(fr);
		String Line = br.readLine();
		String[] strArr = Line.split(":");
		String storedPwd = strArr[1]; 
		FileReader fr2 = new FileReader("C:\\Users\\ABHI\\OneDrive\\Documents\\balance.txt");
		BufferedReader br2 = new BufferedReader(fr2);
		String AvaiBal = br2.readLine();
		int AvailableBal = Integer.parseInt(AvaiBal);
		String responseMsg ="";
		if (!pwd.equals(storedPwd)) {
			responseMsg = "Invalid Password";
		} else {
			if (withdrawAmount>AvailableBal) {
				responseMsg ="Insufficient Balance. Please enter sufficient balance";	
			}else {
				int Newbalance = AvailableBal-withdrawAmount;
				FileWriter fw2 = new FileWriter("C:\\Users\\ABHI\\OneDrive\\Documents\\balance.txt");
				BufferedWriter bw2 = new BufferedWriter(fw2);
				bw2.write(Integer.toString(Newbalance));
				responseMsg ="amount  Rs."+withdrawAmount+ " withdraw succesful";
			   bw2.close();
			}
		}
		String HTMresponsee="<button><a href=\"Homepage.html\">HOME</a></button>";
		String HTMLresponse="<html><body><h1>" + responseMsg +"</h1></body></html>";
		PrintWriter pw = response.getWriter();
		pw.write(HTMLresponse);
		pw.write(HTMresponsee);
		
		
		
		
	}

}
