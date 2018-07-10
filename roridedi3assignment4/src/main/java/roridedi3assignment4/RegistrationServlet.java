package roridedi3assignment4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = request.getParameter("name");
		String email = request.getParameter("email");
		String employmentStatus = request.getParameter("employmentstatus");
		String vehicle = request.getParameter("vehicle");
		String[] courses = request.getParameterValues("courses");
		Registration registration = new Registration();
		registration.setFirstName(firstName);
		registration.setEmail(email);
		registration.setEmploymentStatus(employmentStatus);
		registration.setVehicle(vehicle);
		List<String> courseArray = Arrays.asList(courses);
		registration.setCourses(courseArray);
		String price= null;
		if (employmentStatus.equalsIgnoreCase("student")) {
			price = "1000";
		} else if (employmentStatus.equalsIgnoreCase("employee")) {
			 price = "850";
		} else if (employmentStatus.equalsIgnoreCase("other")) {
			price = "1350";
		}
		registration.setPrice(price);
		if(vehicle !=null){
			registration.setHotelPrice("185");
		}else {
			registration.setHotelPrice("0");
		}
		int tt= courses.length;
		int t3= (tt * Integer.valueOf(price))+ Integer.valueOf(registration.getHotelPrice());
		String total=String.valueOf(t3);
		registration.setTotal(total);
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		request.setAttribute("registration", registration);
		try {
			rd.forward(request, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
