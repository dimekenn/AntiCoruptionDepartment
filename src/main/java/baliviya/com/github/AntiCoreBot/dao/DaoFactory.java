package baliviya.com.github.AntiCoreBot.dao;

import baliviya.com.github.AntiCoreBot.dao.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DaoFactory {

    private static DaoFactory daoFactory = new DaoFactory();
    private static JdbcTemplate jdbcTemplate;
    private static DataSource source;

    @Autowired
    public void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        source = dataSource;
    }

    public static DaoFactory getFactory() {
        return daoFactory;
    }

    public static DataSource getDataSource() {
        return source;
    }

    public AppealTypeDao getAppealTypeDao() {
        return new AppealTypeDao(jdbcTemplate);
    }

    public KeyboardMarkUpDao getKeyboardMarkUpDao() {
        return new KeyboardMarkUpDao(jdbcTemplate);
    }

    public ButtonDao getButtonDao(){
        return new ButtonDao(jdbcTemplate);
    }

    public MessageDao getMessageDao(){
        return new MessageDao(jdbcTemplate);
    }

    public CitizensEmployeeDao getCitizensEmployeeDao(){return new CitizensEmployeeDao(jdbcTemplate);}
}
