package com.ortech.roridedi3assignment5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

//		String price = null;
//        String firstName = request.getParameter("name");
//		String email = request.getParameter("email");
//		String employmentStatus = request.getParameter("employmentstatus");
//		String vehicle = request.getParameter("vehicle");
//		String[] courses = request.getParameterValues("courses");
		Registration registration = (Registration) session.getAttribute("registration");
//		registration.setFirstName(firstName);
//		registration.setEmail(email);
//		registration.setEmploymentStatus(employmentStatus);
//		registration.setVehicle(vehicle);
//		List<String> courseArray = Arrays.asList(courses);
//		List<Course> courseList = new ArrayList<Course>();
//		for (String courseName : courseArray) {
//			Course c = new Course();
//			c.setCourseId(courseName);
//			c.setCourseName(courseName);
//			courseList.add(c);
//		}
//		registration.setCourses(courseList);
//		if (employmentStatus.equalsIgnoreCase("student")) {
//			price = "1000";
//		} else if (employmentStatus.equalsIgnoreCase("employee")) {
//			price = "850";
//		} else if (employmentStatus.equalsIgnoreCase("other")) {
//			price = "1350";
//		}
//		registration.setPrice(price);
//		if (vehicle != null) {
//			registration.setHotelPrice("185");
//		} else {
//			registration.setHotelPrice("0");
//		}

            String to = registration.getEmail();
            String from = "orisdev@gmail.com";
            String subject = "Software Development Seminar Registration Confirmation";
            String body = "<html>"
                + "<head>"
                + "<h1 style=\"padding-left: 140px\">JOHNS HOPKINS ANNUAL SOFTWARE DEVELOPMENT SEMINAR</h1>"
                + "<hr width=\"99%\" color=\"#C4C2C2\"></hr><br>"
                + "</head>"
                + "<body>"
                + "<h3>" + registration.getFirstName()  + "</h3><br>"
                + "You have been confirmed for the Johns Hopkins Annual Software Development Seminar.<br>"
                + "You are registered as a <b>" + registration.getEmploymentStatus()+ ".</b><br><br>"
                + "If you need to update your registration information, please contact the conference committee at <br>"
                + "<a href=\"mailto:registration@seminar.jhu.edu\">registration@seminar.jhu.edu</a>" +
                "    or at (410) 410-4100.<br><br>"
                + "  <table class=\"cTable\" style=\"width:50%\">" +
                "        <tr>" +
                "            <th>Courses</th>" +
                "            <th>Cost</th>" +
                "        </tr>";
            for (Course c: registration.getCourses()) {
                body += "<tr valign=\"middle\"><td>" + c.getCourseName() + "</td>"
                        + "<td>$" + registration.getPrice() + ".00</td></tr>";
            }

            body += "<tr> </tr>";
            if (registration.getHotelPrice() != null) {
                body += "<tr valign=\"middle\">"
                        + "<td>Hotel Accommodation (parking included)</td>" +
                        "  <td>$185.00</td>" +
                        "</tr>";
            }
            if ((registration.getVehicle() !=null) && (!registration.getVehicle().isEmpty())) {
                body += "        <tr valign=\"middle\">" +
                        "            <td>Parking</td>" +
                        "            <td>$10.00</td>" +
                        "        </tr>";
            }

            body += "        <tr valign=\"middle\">" +
                    "            <td><strong>Total</strong></td>" +
                    "            <td><strong>$" + registration.getTotal() + ".00</strong></td>" +
                    "        </tr>" +
                    "    </table>"
                    + "</body>"
                    + "</html>";


            try {
				MailUtilGmail.sendEmail(to, from, subject, body);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              String url = "/confirmed.jsp";


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);

    }
}