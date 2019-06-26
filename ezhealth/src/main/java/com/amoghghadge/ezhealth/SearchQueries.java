package com.amoghghadge.ezhealth;

import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteSqlRequest;
import com.amazonaws.services.rdsdata.model.ExecuteSqlResult;
import com.amazonaws.services.rdsdata.model.Record;
import com.amazonaws.services.rdsdata.model.SqlStatementResult;
//import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.List;
import java.util.Map;

public class SearchQueries implements RequestHandler <Map <String, Object>, String> {

    public static final String RESOURCE_ARN = "arn:aws:rds:us-east-1:420279361566:cluster:ezhealth";
    public static final String SECRET_ARN = "arn:aws:secretsmanager:us-east-1:420279361566:secret:rds-db-credentials/cluster-KEATTN6U4T6DI5ANTF3CXWUA5U/amogh-77wkHw";
    public static String RESPONSE = "";
    public static void main(String[] args) {
        
        System.out.println("Hello");

    }

    public String handleRequest(Map<String, Object> input, Context context) {

        //From the first box (Condition, procedure, doctor name..)
        String last_name = input.getOrDefault("last_name", null).toString();
        String first_name = input.getOrDefault("first_name", null).toString();
        String specialty = input.getOrDefault("specialty", null).toString();
        String condition = input.getOrDefault("condition", null).toString();
        String pp_prac_name = input.getOrDefault("pp_prac_name", null).toString();
        
        //From the second box (Zip code or City)
        String pp_zip = input.getOrDefault("pp_zip", null).toString();
        String city = input.getOrDefault("city", null).toString();

        //From the third box (Appointment Date)
        String date = input.getOrDefault("date", null).toString();

        //From the fourth box (Insurance)
        String insurance = input.getOrDefault("insurance", null).toString();    

        RESPONSE = search(last_name, first_name, specialty, condition, pp_prac_name, pp_zip, city, date, insurance);

        return RESPONSE;

    }

    public static String search (String last_name, String first_name, String specialty, String condition, String pp_prac_name, String pp_zip, String city,
    String date, String insurance) {

        AWSRDSData rdsData = AWSRDSDataClient.builder().build();

        ExecuteSqlRequest request = new ExecuteSqlRequest()
        .withDbClusterOrInstanceArn(RESOURCE_ARN)
        .withAwsSecretStoreArn(SECRET_ARN)
        .withDatabase("ezhealth")
        .withSqlStatements("select * from providers where first_name='" + first_name + "'");

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
    public static String search (String last_name, String first_name, String specialty, String condition, String pp_prac_name, String pp_zip, String city,
   String date, String insurance) {

       AWSRDSData rdsData = AWSRDSDataClient.builder().build();

       ExecuteSqlRequest request = new ExecuteSqlRequest()
       .withDbClusterOrInstanceArn(RESOURCE_ARN)
       .withAwsSecretStoreArn(SECRET_ARN)
       .withDatabase("database")
       .withSqlStatements("select * from providers where last_name=‘Ghadge’");

       ExecuteSqlResult result = rdsData.executeSql(request);

       for (SqlStatementResult fields: result.getSqlStatementResults()) {

           String stringValue = fields.getResultFrame().getRecords().get(0).toString();

           System.out.println();

       }

       return "hi";

   }
*/
}
