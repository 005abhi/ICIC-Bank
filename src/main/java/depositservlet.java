

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class depositservlet
 */
public class depositservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public depositservlet() {
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
		String AddedAmount = request.getParameter("depositAmt");
		int Addedbalance = Integer.parseInt(AddedAmount);
		FileReader fr = new FileReader("C:\\Users\\ABHI\\OneDrive\\Documents\\balance.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		br.close();
		int AvailableAmt = Integer.parseInt(line);
		int Newbalance = AvailableAmt + Addedbalance;
		FileWriter fw2 = new FileWriter("C:\\Users\\ABHI\\OneDrive\\Documents\\balance.txt");
		BufferedWriter bw2 = new BufferedWriter(fw2);
		bw2.write(Integer.toString(Newbalance));
		bw2.close();
		String HTMresponsee="<button><a href=\"Homepage.html\">HOME</a></button>";
		String HTMresponse="<html><body><h3>New Balance is:</h3><h3> Rs." + Newbalance +" </h3></body></html>";
		PrintWriter pw= response.getWriter();
		pw.write(HTMresponse);
		pw.write(HTMresponsee);
		
	}

}

