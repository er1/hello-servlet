package com.tamaranch.apps.hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author er1
 */
@WebServlet(name = "IndexServlet", description = "Index Servlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://172.17.0.1:3306/www", "www", "www")) {

            List<String> items = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT content FROM item;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(resultSet.getString("content"));
            }
            request.setAttribute("items", items);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/hello2.jsp");
            requestDispatcher.forward(request, response);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
