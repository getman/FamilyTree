package ru.aparfenov.familytree.servlet.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Artem Parfenov on 12.11.15.
 */
public class ClientRequestProcessingTest {
    //------------Data members-----------
    private static final Logger logger = LogManager.getLogger(DbConnectionTest.class);

    //------------Methods-----------
//    @Test
    public void testPersonCreation() throws IOException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ServletException {
        /*DataSource ds = DbConnectionTest.getPostgreDataSource();
        Connection connection = ds.getConnection();
        Statement callable = connection.createStatement();
        ResultSet rs = callable.executeQuery("SELECT * FROM test");
        if (rs.next()) {
            System.out.println("Data base is available");
            logger.info("Data base is available");
        }*/
        try{
            Class<?> c = Class.forName("ru.getman.familytree.servlet.MainServlet");
            java.lang.reflect.Method method = c.getDeclaredMethod("processClientRequest", HttpServletRequest.class,
                    HttpServletResponse.class);
            method.setAccessible(true);
            HttpServletRequest httpReq = new HttpServletRequest() {
                @Override
                public String getAuthType() {
                    return null;
                }

                @Override
                public Cookie[] getCookies() {
                    return new Cookie[0];
                }

                @Override
                public long getDateHeader(String s) {
                    return 0;
                }

                @Override
                public String getHeader(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getHeaders(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getHeaderNames() {
                    return null;
                }

                @Override
                public int getIntHeader(String s) {
                    return 0;
                }

                @Override
                public String getMethod() {
                    return null;
                }

                @Override
                public String getPathInfo() {
                    return null;
                }

                @Override
                public String getPathTranslated() {
                    return null;
                }

                @Override
                public String getContextPath() {
                    return null;
                }

                @Override
                public String getQueryString() {
                    return "Some shit";
                }

                @Override
                public String getRemoteUser() {
                    return null;
                }

                @Override
                public boolean isUserInRole(String s) {
                    return false;
                }

                @Override
                public Principal getUserPrincipal() {
                    return null;
                }

                @Override
                public String getRequestedSessionId() {
                    return null;
                }

                @Override
                public String getRequestURI() {
                    return null;
                }

                @Override
                public StringBuffer getRequestURL() {
                    return null;
                }

                @Override
                public String getServletPath() {
                    return null;
                }

                @Override
                public HttpSession getSession(boolean b) {
                    return null;
                }

                @Override
                public HttpSession getSession() {
                    return null;
                }

                @Override
                public String changeSessionId() {
                    return null;
                }

                @Override
                public boolean isRequestedSessionIdValid() {
                    return false;
                }

                @Override
                public boolean isRequestedSessionIdFromCookie() {
                    return false;
                }

                @Override
                public boolean isRequestedSessionIdFromURL() {
                    return false;
                }

                @Override
                public boolean isRequestedSessionIdFromUrl() {
                    return false;
                }

                @Override
                public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
                    return false;
                }

                @Override
                public void login(String s, String s2) throws ServletException {

                }

                @Override
                public void logout() throws ServletException {

                }

                @Override
                public Collection<Part> getParts() throws IOException, ServletException {
                    return null;
                }

                @Override
                public Part getPart(String s) throws IOException, ServletException {
                    return null;
                }

                @Override
                public <T extends HttpUpgradeHandler> T upgrade(Class<T> tClass) throws IOException, ServletException {
                    return null;
                }

                @Override
                public Object getAttribute(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getAttributeNames() {
                    return null;
                }

                @Override
                public String getCharacterEncoding() {
                    return null;
                }

                @Override
                public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

                }

                @Override
                public int getContentLength() {
                    return 0;
                }

                @Override
                public long getContentLengthLong() {
                    return 0;
                }

                @Override
                public String getContentType() {
                    return null;
                }

                @Override
                public ServletInputStream getInputStream() throws IOException {
                    return null;
                }

                @Override
                public String getParameter(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getParameterNames() {
                    return null;
                }

                @Override
                public String[] getParameterValues(String s) {
                    return new String[0];
                }

                @Override
                public Map<String, String[]> getParameterMap() {
                    return null;
                }

                @Override
                public String getProtocol() {
                    return null;
                }

                @Override
                public String getScheme() {
                    return null;
                }

                @Override
                public String getServerName() {
                    return null;
                }

                @Override
                public int getServerPort() {
                    return 0;
                }

                @Override
                public BufferedReader getReader() throws IOException {
                    return null;
                }

                @Override
                public String getRemoteAddr() {
                    return null;
                }

                @Override
                public String getRemoteHost() {
                    return null;
                }

                @Override
                public void setAttribute(String s, Object o) {

                }

                @Override
                public void removeAttribute(String s) {

                }

                @Override
                public Locale getLocale() {
                    return null;
                }

                @Override
                public Enumeration<Locale> getLocales() {
                    return null;
                }

                @Override
                public boolean isSecure() {
                    return false;
                }

                @Override
                public RequestDispatcher getRequestDispatcher(String s) {
                    return null;
                }

                @Override
                public String getRealPath(String s) {
                    return null;
                }

                @Override
                public int getRemotePort() {
                    return 0;
                }

                @Override
                public String getLocalName() {
                    return null;
                }

                @Override
                public String getLocalAddr() {
                    return null;
                }

                @Override
                public int getLocalPort() {
                    return 0;
                }

                @Override
                public ServletContext getServletContext() {
                    return null;
                }

                @Override
                public AsyncContext startAsync() throws IllegalStateException {
                    return null;
                }

                @Override
                public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
                    return null;
                }

                @Override
                public boolean isAsyncStarted() {
                    return false;
                }

                @Override
                public boolean isAsyncSupported() {
                    return false;
                }

                @Override
                public AsyncContext getAsyncContext() {
                    return null;
                }

                @Override
                public DispatcherType getDispatcherType() {
                    return null;
                }
            };
            HttpServletResponse httpResp = new HttpServletResponse() {
            @Override
            public void addCookie(Cookie cookie) {

            }

            @Override
            public boolean containsHeader(String s) {
                return false;
            }

            @Override
            public String encodeURL(String s) {
                return null;
            }

            @Override
            public String encodeRedirectURL(String s) {
                return null;
            }

            @Override
            public String encodeUrl(String s) {
                return null;
            }

            @Override
            public String encodeRedirectUrl(String s) {
                return null;
            }

            @Override
            public void sendError(int i, String s) throws IOException {

            }

            @Override
            public void sendError(int i) throws IOException {

            }

            @Override
            public void sendRedirect(String s) throws IOException {

            }

            @Override
            public void setDateHeader(String s, long l) {

            }

            @Override
            public void addDateHeader(String s, long l) {

            }

            @Override
            public void setHeader(String s, String s2) {

            }

            @Override
            public void addHeader(String s, String s2) {

            }

            @Override
            public void setIntHeader(String s, int i) {

            }

            @Override
            public void addIntHeader(String s, int i) {

            }

            @Override
            public void setStatus(int i) {

            }

            @Override
            public void setStatus(int i, String s) {

            }

            @Override
            public int getStatus() {
                return 0;
            }

            @Override
            public String getHeader(String s) {
                return "some header";
            }

            @Override
            public Collection<String> getHeaders(String s) {
                return new ArrayList<>();
            }

            @Override
            public Collection<String> getHeaderNames() {
                return new ArrayList<>();
            }

            @Override
            public String getCharacterEncoding() {
                return "";
            }

            @Override
            public String getContentType() {
                return "";
            }

            @Override
            public ServletOutputStream getOutputStream() throws IOException {
                return null;
            }

            @Override
            public PrintWriter getWriter() throws IOException {
                return null;
            }

            @Override
            public void setCharacterEncoding(String s) {

            }

            @Override
            public void setContentLength(int i) {

            }

            @Override
            public void setContentLengthLong(long l) {

            }

            @Override
            public void setContentType(String s) {

            }

            @Override
            public void setBufferSize(int i) {

            }

            @Override
            public int getBufferSize() {
                return 0;
            }

            @Override
            public void flushBuffer() throws IOException {

            }

            @Override
            public void resetBuffer() {

            }

            @Override
            public boolean isCommitted() {
                return false;
            }

            @Override
            public void reset() {

            }

            @Override
            public void setLocale(Locale locale) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }
        };

            method.invoke(c.newInstance(), httpReq, httpResp);
        } catch (ClassNotFoundException e) {
//        } catch (InvocationTargetException e) {
            System.out.println(e);
            logger.error(e);
        }
    }
}