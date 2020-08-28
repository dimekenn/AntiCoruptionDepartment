package baliviya.com.github.AntiCoreBot.dao.impl;

import baliviya.com.github.AntiCoreBot.dao.AbstractDao;
import baliviya.com.github.AntiCoreBot.model.standart.Button;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ButtonDao extends AbstractDao<Button> {
    public ButtonDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void update(Button button) {
        sql = "UPDATE BUTTON SET NAME = ?, URL = ? WHERE ID = ? AND LANG_ID = ?";
        jdbcTemplate.update(sql, button.getName(), button.getUrl(), button.getId(), button.getLangId());
    }

    @Override
    protected Button mapper(ResultSet rs, int index) throws SQLException {
        Button button = new Button();
        button.setId(rs.getInt(1));
        button.setName(rs.getString(2));
        button.setCommandId(rs.getInt(3));
        button.setUrl(rs.getString(4));
        button.setRequestContact(rs.getBoolean(5));
        button.setMessageId(rs.getInt(6));
        button.setLangId(rs.getInt(7));
        return button;
    }
}
