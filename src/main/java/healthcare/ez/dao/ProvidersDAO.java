package healthcare.ez.dao;

import java.util.List;

import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteSqlRequest;
import com.amazonaws.services.rdsdata.model.ExecuteSqlResult;
import com.amazonaws.services.rdsdata.model.Record;
import com.amazonaws.services.rdsdata.model.SqlStatementResult;

import healthcare.ez.model.Providers;

public class ProvidersDAO {

	public static final String RESOURCE_ARN = "aealth";
    public static final String SECRET_ARN = "arn:aws7wkHw";

	public static Providers[] search() {

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

        ExecuteSqlRequest request = new ExecuteSqlRequest()
        .withDbClusterOrInstanceArn(RESOURCE_ARN)
        .withAwsSecretStoreArn(SECRET_ARN)
        .withDatabase("ezhealth")
        .withSqlStatements("select * from providers");

        ExecuteSqlResult result = rdsData.executeSql(request);

		int size = (result.getSqlStatementResults().size())/30;

		Providers[] doctors = new Providers[size];

		for (int i=0; i<size; i++) {

			doctors[i] = new Providers();

		}

        for (SqlStatementResult fields: result.getSqlStatementResults()) {

			System.out.println(fields.getResultFrame().getRecords());

			int increments = 30;
			
			for (int i=0; i<size; i++) {
			
				if (i==0) {
					
					doctors[0].setLastName(fields.getResultFrame().getRecords().get(1).toString());
					doctors[0].setFirstName(fields.getResultFrame().getRecords().get(2).toString());
					doctors[0].setSelfSpecCode(fields.getResultFrame().getRecords().get(19).toString());
					doctors[0].setPpPracName(fields.getResultFrame().getRecords().get(7).toString());
					doctors[0].setPpZip(fields.getResultFrame().getRecords().get(12).toString());
					doctors[0].setPpCity(fields.getResultFrame().getRecords().get(10).toString());
			
				} else {
			
					doctors[i].setLastName(fields.getResultFrame().getRecords().get(1+increments*i).toString());
					doctors[i].setFirstName(fields.getResultFrame().getRecords().get(2+increments*i).toString());
					doctors[i].setSelfSpecCode(fields.getResultFrame().getRecords().get(19+increments*i).toString());
					doctors[i].setPpPracName(fields.getResultFrame().getRecords().get(7+increments*i).toString());
					doctors[i].setPpZip(fields.getResultFrame().getRecords().get(12+increments*i).toString());
					doctors[i].setPpCity(fields.getResultFrame().getRecords().get(10+increments*i).toString());
			
				}
			
			}
			
		}

        return doctors;

	}

}
