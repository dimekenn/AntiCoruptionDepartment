package baliviya.com.github.AntiCoreBot.dao.impl;

import baliviya.com.github.AntiCoreBot.dao.AbstractDao;
import baliviya.com.github.AntiCoreBot.model.custom.AppealType;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppealTypeDao extends AbstractDao<AppealType> {

    public AppealTypeDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public int insert(AppealType appealType) {
        sql = "INSERT INTO APPEAL_TYPE (NAME, LANG_ID) VALUES(?,?)";
        return (int) getDBUtils().updateForKeyId(sql, appealType.getName(), appealType.getLangId());
    }

    public int insertWithId(AppealType appealType) {
        sql = "INSERT INTO APPEAL_TYPE (ID, NAME, LANG_ID) VALUES(?,?,?)";
        return (int) getDBUtils().updateForKeyId(sql, appealType.getId(), appealType.getName(), appealType.getLangId());
    }

    public void delete(int appealTypeId) {
        sql = "DELETE FROM APPEAL_TYPE WHERE ID = ?";
        jdbcTemplate.update(sql, appealTypeId);
    }

    public void update(AppealType appealType) {
        sql = "UPDATE APPEAL_TYPE SET NAME = ? WHERE ID = ? AND LANG_ID = ?";
        jdbcTemplate.update(sql, appealType.getName(), appealType.getId(), appealType.getLangId());
    }

    @Override
    protected AppealType mapper(ResultSet rs, int index) throws SQLException {
        AppealType appealType = new AppealType();
        appealType.setId(rs.getInt(1));
        appealType.setName(rs.getString(2));
        appealType.setLangId(rs.getInt(3));
        return appealType;
    }
}
