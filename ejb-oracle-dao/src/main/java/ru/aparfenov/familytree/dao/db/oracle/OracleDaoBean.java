package ru.aparfenov.familytree.dao.db.oracle;

import ru.aparfenov.familytree.model.ElementDto;
import ru.aparfenov.familytree.model.ElementFactory;
import ru.aparfenov.familytree.model.Param;
import ru.aparfenov.familytree.model.elements.Element;
import ru.aparfenov.familytree.model.elements.Person;
import ru.aparfenov.familytree.storage.dao.DbDao;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Отвечает за хранение элементов в БД Oracle
 * Created by ArtemParfenov on 27.05.2017.
 */
@Stateless
public class OracleDaoBean implements DbDao {
    @Resource(name = "jdbc/oracle_ds")
    private DataSource oracleDs;

    private static final Logger logger = LogManager.getLogger(OracleDaoBean.class);

    public static final String ORA_SELECT_ALL_PERSON = "select * from person";
    public static final String ORA_ADD_PERSON = "insert into person(id, first_name, last_name) values(?, ?, ?)";
    public static final String ORA_REMOVE_PERSON = "delete from person where id = ?";


    @Override
    public List<Element> getElementList(List<Param> params, ElementFactory elementFactory) {
        List<ElementDto> newElementDtoList = new ArrayList<>();
        logger.debug("Going to receive a list of elements...");
        try (Connection conn = oracleDs.getConnection()) {
            PreparedStatement ps = conn.prepareCall(ORA_SELECT_ALL_PERSON);
            ResultSet rs = ps.executeQuery();
            List<String> fldList = elementFactory.getElementParamNames();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            int rowCount = 0;
            while(rs.next()) {
                ElementDto newElementDto = new ElementDto();
                newElementDto.setId(rs.getString(ElementFactory.ELEMENT_ID_PARAM_NAME));
                //все поля ResultSet назначаем свойствам DTO в соответствии с типом данных из
                //ResultSetMetadata
                logger.debug("record " + rowCount++);
                for (int i = 0; i < columnCount; i++) {
                    String nextFldName = rsMetaData.getColumnName(i+1);
                    String typeName = rsMetaData.getColumnTypeName(i+1);
                    logger.debug("nextFld name:" + nextFldName + ", type name: " + typeName);
                    Param newParam = null;
                    switch (typeName) {
                        case "VARCHAR2":
                            newParam = new Param(nextFldName, rs.getString(i + 1));
                            break;
                        case "NUMBER":
                            newParam = new Param(nextFldName, rs.getInt(i + 1));
                            break;
                        case "BOOL":
                            newParam = new Param(nextFldName, rs.getBoolean(i + 1));
                            break;
                        default:
                            logger.error("Unknown type: " + typeName + " of column:" + nextFldName);
                            continue;
                    }
                    logger.debug("New param: " + nextFldName + "(" + typeName + ")" + "=" + String.valueOf(newParam.getValue()));
                    newElementDto.addParam(nextFldName, newParam);
                }

                newElementDtoList.add(newElementDto);
            }
        } catch (SQLException e) {
            logger.error("SQL exception", e);
        }
        return elementFactory.buidlElementList(newElementDtoList);
    }

    @Override
    public Element getElement(String id, ElementFactory elementFactory) {

        //TODO исключительно неаккуратное решение, вынести запросы в конфиг либо в ХП
        //SQL запрос на получение данных из таблицы для соответствующего типа ElementFactory

        ElementDto newElementDto = new ElementDto();
        System.out.println("Going to get DB connection...");
        try (Connection conn = oracleDs.getConnection()) {

            PreparedStatement ps = conn.prepareCall("select * from dual");
            ResultSet rs = ps.executeQuery();
            rs.next();
            logger.info("Oracle answer is " + rs.getString(1));
            System.out.println("DB answer is:" + rs.getString(1));
            newElementDto.setId("1");
            List<String> fldList = elementFactory.getElementParamNames();
            int i = 0;
            for (String nextFld: fldList) {
                logger.debug("nextFld name:" + nextFld);
                newElementDto.addParam(nextFld, new Param(nextFld, "fld" + (i++)));
            }
        } catch (SQLException e) {
            logger.error("DB error", e);
        }
        return elementFactory.buidlElement(newElementDto);
    }

    @Override
    public Element getElementByParams(List<Param> params, ElementFactory elementFactory) {
        return null;
    }

    public void addElement(Element newElement, ElementFactory elementFactory) {
        logger.info("Inserting new element into Oracle DB");
        try (Connection conn = oracleDs.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(ORA_ADD_PERSON);
            ps.setString(1, newElement.getId());
            ps.setString(2, ((Person)newElement).getFirstName());
            ps.setString(3, ((Person)newElement).getLastName());
            ps.executeUpdate();
            logger.info("Added record for person: " + newElement.getId() + "," + ((Person)newElement).getFirstName() +
                    "/" + ((Person)newElement).getLastName());
        } catch (SQLException e) {
            logger.error("DB error", e);
        }
    }

    public void removeElement(String id, ElementFactory elementFactory) {
        logger.info("Removing element with id: " + id + " from Oracle DB");
        try (Connection conn = oracleDs.getConnection()) {
            PreparedStatement pst = conn.prepareCall(ORA_REMOVE_PERSON);
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.error("DB error", e);
        }
    }

    public void init() {

    }
}
