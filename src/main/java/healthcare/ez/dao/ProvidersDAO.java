package healthcare.ez.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.sbc.model.SeatHold;
import com.sbc.model.Seats;

public class ProvidersDAO  {

	private JdbcTemplate jdbcTemplate;

	public SeatHoldDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	@Transactional
	@Override
	public int reserveSeats(int seatHoldId, String customerEmail) {
		String sql = "update seats set status=2 where (DATEDIFF('second',lastheldtime, CURRENT_TIMESTAMP())-900 <0) AND status = 1 AND seatholdId=?";
		int rows = this.jdbcTemplate.update(sql, seatHoldId);
		if (rows<=0) seatHoldId=-1;
		return seatHoldId;
	}

}