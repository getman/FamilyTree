package ru.getman.familytree.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.getman.familytree.servlet.dao.DAOFactory;
import ru.getman.familytree.servlet.dao.PersonDAO;
import ru.getman.familytree.servlet.dao.PostgreSqlDaoFactory;
import ru.getman.familytree.servlet.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Artem Parfenov on 26.10.15.
 * Рисует главную страницу, отправляет запросы на формирование списков объектов, отрисовывает полученные результаты
 */
@WebServlet("/")
public class MainServlet extends HttpServlet{
    private static final Logger logger = LogManager.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        request.setAttribute("name", "Getman");
        request.getRequestDispatcher("indexPage.jsp").forward(request, responce);
        System.out.println("Show main page");

        //process any client requests
        processClientRequest(request, responce);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processClientRequest(req, resp);
    }

    /**Processes a responce received from the browser
     * @param request HttpServletRequest - user browser request
     * @param responce HttpServletResponse - user browser response*/
    private void processClientRequest(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        if (request.getQueryString() != null) {
            /*if (logger.isDebugEnabled()) {
                logger.debug("Client data received, content length: " + request.getQueryString());
                logger.debug("parameter1=" + request.getParameter("parameter1"));
            }*/
            System.out.println("Client data received, content length: " + request.getQueryString());
            System.out.println("parameter1=" + request.getParameter("parameter1"));
            DAOFactory daoFactory = new PostgreSqlDaoFactory();
            try (Connection conn = daoFactory.getConnection()){
                PersonDAO personDao = daoFactory.getPersonDao(conn);
                Person testPerson = personDao.getPerson(1);
                request.setAttribute("name", testPerson.getName());
                /*if (logger.isDebugEnabled()) {
                    logger.debug("test person received: " + testPerson.getName() + "/" + testPerson.getAge());
                }*/
                System.out.println("test person received: " + testPerson.getName() + "/" + testPerson.getAge());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher rd = request.getRequestDispatcher("personPage.jsp");
            rd.forward(request, responce);
        }
    }

}
