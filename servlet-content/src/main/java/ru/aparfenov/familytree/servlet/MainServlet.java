package ru.aparfenov.familytree.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.model.ElementTypes;
import ru.aparfenov.familytree.manager.ElementManager;
import ru.aparfenov.familytree.model.elements.Person;
import ru.aparfenov.familytree.model.elements.Photo;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem Parfenov on 26.10.15.
 * Рисует главную страницу, отправляет запросы на формирование списков объектов, отрисовывает полученные результаты
 */
@WebServlet (name="MainServlet", urlPatterns={"/family_tree"}, initParams =     {@WebInitParam(name="test",value="annotation")})
public class MainServlet extends HttpServlet{
    private static final Logger logger = LogManager.getLogger(MainServlet.class);

    @EJB
    ElementManager elementMngr;

    /**Обрабатывает get запрос от клиента*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Sending a GET request");
        selectStartData(request, response);
    }

    /**Обрабатывает post запрос от клиента*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Sending a POST request");

        String action = request.getParameter("action");
        String personId = request.getParameter("person_id");
        logger.info("Action is:" + action + ", person id: " + personId);
        if (action != null) {
            if ("see_more".equals(action)) {
                try {
                    seeMore(request, resp);
                    selectStartData(request, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if ("remove_person".equals(action)) {
                try {
                    removePerson(personId);
                    selectStartData(request, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if ("add_person".equals(action)) {
                try{
                    addPerson(request);
                    selectStartData(request, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            logger.error("Unknown action");
        }
//        response.sendRedirect("book_store");
//        selectStartData(request, resp);
        //перенаправляет клиента на страницу
//        resp.sendRedirect("family_tree");
    }

    private void addPerson(HttpServletRequest request) {
        String newPersonId = request.getParameter("new_person_id_input");
        String newPersonName = request.getParameter("new_person_name_input");
        String newPersonSurname = request.getParameter("new_person_surname_input");
        Person newPerson = new Person(newPersonId);
        newPerson.setFirstName(newPersonName);
        newPerson.setLastName(newPersonSurname);
        logger.debug("New person is ready: " + newPerson.getId() + "/" + newPerson.getFirstName() + "/" +
                newPerson.getLastName());
        elementMngr.addNewElement(newPerson);
    }

    /**Стартовая загрузка данных - первичные списки персон*/
    private void selectStartData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Param> params = new ArrayList<>();
        List<Element> elements = elementMngr.getElements(params, ElementTypes.PERSON);
        request.setAttribute("personList", elements);
        request.getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }

    /**Обрабатывает POST запрос от клиента на получение дополнительных данных о персоне*/
    private void seeMore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String personId = request.getParameter("person_id");
        logger.debug("See more about person: id=" + personId);
        List<Param> params = new ArrayList<>();
        params.add(new Param("photo_person_id", personId));
        Element photoElement = elementMngr.findElementByParams(params, ElementTypes.PHOTO);
        request.setAttribute("photo", ((Photo)photoElement).getComment());
        logger.debug("Found Photo with comment: " + ((Photo) photoElement).getComment());
        request.setAttribute("photo_person_id", personId);
    }

    private void removePerson(String personId) {
        elementMngr.removeElement(personId, ElementTypes.PERSON);
    }
}

