package baliviya.com.github.AntiCoreBot.dao;

import baliviya.com.github.AntiCoreBot.configuration.Conversation;
import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.service.LanguageService;
import baliviya.com.github.AntiCoreBot.util.DataBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public abstract class AbstractDao<T> {

    protected static    DaoFactory      factory;
    protected           String          sql;
    protected           JdbcTemplate    jdbcTemplate;

    static { factory = DaoFactory.getFactory(); }

    public AbstractDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    protected abstract  T               mapper(ResultSet rs, int index) throws SQLException;

    protected           Object[]        setParam(Object... args) { return args; }

    protected static    DataBaseUtils   getDBUtils() { return new DataBaseUtils(DaoFactory.getDataSource()); }

    protected Language getLanguage() {
        if (getChatId() == 0) return Language.ru;
        return LanguageService.getLanguage(getChatId());
    }

    private long getChatId() {
        return Conversation.getCurrentChatId();
    }
}
