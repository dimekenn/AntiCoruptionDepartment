package baliviya.com.github.AntiCoreBot.dao.impl;

import baliviya.com.github.AntiCoreBot.dao.AbstractDao;
import baliviya.com.github.AntiCoreBot.model.custom.CitizensEmployee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CitizensEmployeeDao extends AbstractDao<CitizensEmployee> {
    public CitizensEmployeeDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public boolean isCitizenEmployee(long chatId) {
        sql = "SELECT count(*) FROM CITIZENS_EMPLOYEE WHERE CHAT_ID = ?";
        return jdbcTemplate.queryForObject(sql, setParam(chatId), Integer.class) > 0;
    }

    @Override
    protected CitizensEmployee mapper(ResultSet rs, int index) throws SQLException {
        CitizensEmployee citizensEmployee = new CitizensEmployee();
        citizensEmployee.setId(rs.getInt(1));
        citizensEmployee.setChatId(rs.getLong(2));
        citizensEmployee.setReceptionId(rs.getInt(3));
        return citizensEmployee;
    }
}
