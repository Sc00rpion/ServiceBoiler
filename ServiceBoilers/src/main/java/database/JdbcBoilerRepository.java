package database;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Boiler;

@Repository
public class JdbcBoilerRepository implements BoilerRepository {

	private JdbcOperations jdbcOperations;

	@Autowired
	public JdbcBoilerRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
		jdbcOperations.update("use maciek95_junkers");
	}

	private static final String SQL_INSERT_BOILER = "insert into boiler (name, launchDate) values (?, ?)";

	public void addBoiler(Boiler boiler) {
		jdbcOperations.update(SQL_INSERT_BOILER, 
				boiler.getName(), 
				boiler.getLaunchDate());
	}

	private static final String SQL_UPDATE_BOILER = "update boiler set name = ?, launchDate = ? where id = ?";

	public void updateBoiler(Boiler boiler) {
		jdbcOperations.update(SQL_UPDATE_BOILER, 
				boiler.getName(), 
				boiler.getLaunchDate(), 
				boiler.getId());

	}

	private static final String SQL_SELECT_BOILER_BY_ID = "select * from boiler where id = ?";

	public Boiler findById(Long id) {
		return jdbcOperations.queryForObject(SQL_SELECT_BOILER_BY_ID, new BoilerRowMapper(), id);
	}
	private static final String SQL_SELECT_ALL = "select * from boiler";

	public List<Boiler> getBoilers() {
		return jdbcOperations.query(SQL_SELECT_ALL, new BoilerRowMapper());
	}

	
	private static final class BoilerRowMapper implements RowMapper<Boiler> {
		public Boiler mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Boiler(
					rs.getLong("id"), 
					rs.getString("name"), 
					rs.getDate("launchDate"));
		}
	}
}
