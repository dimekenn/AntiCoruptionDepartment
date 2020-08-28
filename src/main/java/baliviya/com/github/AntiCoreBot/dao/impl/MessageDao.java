package baliviya.com.github.AntiCoreBot.dao.impl;

import baliviya.com.github.AntiCoreBot.dao.AbstractDao;
import baliviya.com.github.AntiCoreBot.enums.Language;
import baliviya.com.github.AntiCoreBot.model.standart.Button;
import baliviya.com.github.AntiCoreBot.model.standart.Message;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDao extends AbstractDao<Message> {
    public MessageDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void update(Message message) {
        sql = "UPDATE MESSAGE SET NAME = ?, PHOTO = ?, FILE = ?, FILE_TYPE = ? WHERE ID = ? AND LANGUAGE_ID = ?";
        jdbcTemplate.update(sql, message.getName(), message.getPhoto(), message.getFile(), message.getFileType() == null ? null : message.getFileType(),
                message.getId(), message.getLanguageId());
    }

    public Message getMessage(long messageId) {
        sql = "SELECT * FROM MESSAGE WHERE ID = ? AND LANGUAGE_ID = ?";
        return jdbcTemplate.queryForObject(sql, setParam(messageId, getLanguage().getId()), this::mapper);
    }

    public Message getMessage(long messageId, Language language) {
        sql = "SELECT * FROM MESSAGE WHERE ID = ? AND LANGUAGE_ID = ?";
        return jdbcTemplate.queryForObject(sql, setParam(messageId, language.getId()), this::mapper);
    }


    @Override
    protected Message mapper(ResultSet rs, int index) throws SQLException {
        Message message = new Message();
        message.setId(rs.getInt(1));
        message.setName(rs.getString(2));
        message.setPhoto(rs.getString(3));
        message.setKeyboardId(rs.getInt(4));
        message.setFile(rs.getString(5));
        message.setFileType(rs.getString(6));
        message.setLanguageId(rs.getInt(7));
        return message;
    }
}
