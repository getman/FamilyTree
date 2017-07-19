<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ru.aparfenov.familytree.model.elements.Element" %>
<%@ page import="ru.aparfenov.familytree.model.elements.Person" %>
<%@ page import="ru.aparfenov.familytree.model.elements.Photo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>TaskEE</title>
</head>
<body>
Family tree:
persons:

<% Object personList = request.getAttribute("personList");%>
<% if (personList != null) { %>
    <table>
        <tr>
            <td></td>
            <td>id</td>
            <td>first name</td>
            <td>last name</td>
            <td></td>
            <td>photo</td>
        </tr>

        <% for (Person nextPerson : (List<Person>) personList) { %>
        <tr>
            <td>
                <form method="POST" action="family_tree">
                    <input type="submit" value="-"/>
                    <input type="hidden" name="action" value="remove_person"/>
                    <input type="hidden" name="person_id" value="<%= nextPerson.getId() %>"/>
                </form>
            </td>
            <td><%= nextPerson.getId() %></td>
            <td><%= nextPerson.getFirstName() %></td>
            <td><%= nextPerson.getLastName() %></td>
            <td>
                <form method="POST" action="family_tree">
                    <input type="submit" value="See more"/>
                    <input type="hidden" name="action" value="see_more"/>
                    <input type="hidden" name="person_id" value="<%= nextPerson.getId() %>"/>
                </form>
            </td>
            <td><% Object photoObj = request.getAttribute("photo");%>
                <% if (photoObj != null) { %>
                    <% Object photoPersonId = request.getAttribute("photo_person_id");%>
                    <% if ((photoPersonId != null) && (((String)photoPersonId).equals(nextPerson.getId())) ) { %>
                        <% String photoComment = (String) photoObj; %>
                        <%= photoComment %>
                    <% } %>
                <% } %>
            </td>
        </tr>
        <% } %>
    </table>
<% } else { %>
    no persons
<% } %>

    <form method="POST" action="family_tree">
        <div></div>
        <div></div>
        <div>New person</div>
        <label for="new_person_id">id</label>
        <input name="new_person_id_input" id="new_person_id" value="">
        <label for="new_person_name">name</label>
        <input name="new_person_name_input" id="new_person_name" value="Ivan">
        <label for="new_person_surname">name</label>
        <input name="new_person_surname_input" id="new_person_surname" value="Ivanov">
        <input type="hidden" name="action" value="add_person"/>
        <input type="submit" value="+"/>
    </form>
</body>
</html>

