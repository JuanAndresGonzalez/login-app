package login.LoginApplication.Logica;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

public class Conexion {

    private JdbcTemplate template;

    public Conexion(String user, String pass) {
        DriverManagerDataSource data = new DriverManagerDataSource();
        data.setDriverClassName("com.mysql.jdbc.Driver");
        data.setUrl("jdbc:mysql://localhost:3306/test");
        data.setUsername(user);
        data.setPassword(pass);

        this.template = new JdbcTemplate(data);
    }

    public List<Map<String, Object>> SelectQuery(String sql) {
        try {
            List<Map<String, Object>> result = this.template.queryForList(sql);
            return result;
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Map<String, Object>> SelectQuery(String sql, Object... args) {
        try {
            List<Map<String, Object>> result = this.template.queryForList(sql, args);
            return result;
        } catch (Exception e) {
            throw e;
        }

    }

    public void EjecutarQuery(String sql) {
        try {
            this.template.execute(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(String sql, Object... args) {
        try {
            this.template.update(sql, args);
        } catch (Exception e) {
            throw e;
        }
    }
}
