package healthcare.ez.dao;
/*
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.sbc.model.SeatHold;
import com.sbc.model.Seats;
*/

import java.util.List;

import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteSqlRequest;
import com.amazonaws.services.rdsdata.model.ExecuteSqlResult;
import com.amazonaws.services.rdsdata.model.Record;
import com.amazonaws.services.rdsdata.model.SqlStatementResult;

import healthcare.ez.model.Providers;

public class ProvidersDAO {

	public static final String RESOURCE_ARN = "arn:aws:rds:us-east-1:420279361566:cluster:ezhealth";
    public static final String SECRET_ARN = "arn:aws:secretsmanager:us-east-1:420279361566:secret:rds-db-credentials/cluster-KEATTN6U4T6DI5ANTF3CXWUA5U/amogh-77wkHw";

	public Providers search() {

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

        ExecuteSqlRequest request = new ExecuteSqlRequest()
        .withDbClusterOrInstanceArn(RESOURCE_ARN)
        .withAwsSecretStoreArn(SECRET_ARN)
        .withDatabase("ezhealth")
        .withSqlStatements("select * from providers");

        ExecuteSqlResult result = rdsData.executeSql(request);

        for (SqlStatementResult fields: result.getSqlStatementResults()) {

            List<Record> list = fields.getResultFrame().getRecords();

            String stringValue = fields.getResultFrame().getRecords().get(0).toString();

            //long numberValue = Long.parseLong(fields.getResultFrame().getRecords().get(1).toString());

            System.out.println(String.format("Fetched row: string = %s", stringValue));
            System.out.println(list);

        }

        return "hi";

	}

/*
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
*/
}