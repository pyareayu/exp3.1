package com.employee;

import com.employee.util.DBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String searchId = request.getParameter("emp_id");

        out.println("<html><head><title>Employees</title></head><body>");
        out.println("<h1>Employee Records</h1>");
        out.println("<form action='EmployeeServlet' method='get'>");
        out.println("Search by ID: <input type='text' name='emp_id'/>");
        out.println("<input type='submit' value='Search'/>");
        out.println("</form><br/>");

        try (Connection conn = DBUtil.getConnection()) {

            PreparedStatement ps;
            if (searchId != null && !searchId.trim().isEmpty()) {
                ps = conn.prepareStatement(
                    "SELECT emp_id, name, salary FROM employee WHERE emp_id = ?");
                ps.setInt(1, Integer.parseInt(searchId.trim()));
            } else {
                ps = conn.prepareStatement(
                    "SELECT emp_id, name, salary FROM employee");
            }

            try (ResultSet rs = ps.executeQuery()) {
                out.println("<table border='1' cellpadding='6'>");
                out.println("<tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("emp_id") + "</td>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getDouble("salary") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                if (!found) {
                    out.println("<p>No records found.</p>");
                }
            }
            ps.close();

        } catch (SQLException ex) {
            out.println("<p style='color:red'>Database Error: " + ex.getMessage() + "</p>");
            ex.printStackTrace();
        } catch (NumberFormatException nf) {
            out.println("<p style='color:red'>Invalid Employee ID format (use numeric only).</p>");
        }

        out.println("<br/><a href='employeeSearch.html'>Back</a>");
        out.println("</body></html>");
    }
}
