import utils.JDBC;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        JDBC jdbc = new JDBC();
        Map map = new HashMap();
        for (int i = 0;i < 20;i++){
            try {
                Connection connection = jdbc.getConnection();
                map.put(connection,true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ServletContext application = servletContextEvent.getServletContext();
        application.setAttribute("key",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        JDBC jdbc = new JDBC();
        ServletContext application = servletContextEvent.getServletContext();
        Map map = (Map)application.getAttribute("key");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Connection connection = (Connection)iterator.next();
            if (connection != null) {
                jdbc.close(connection,null,null);
            }
        }
    }
}
