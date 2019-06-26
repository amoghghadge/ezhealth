package healthcare.ez.junk;
/*
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteStatementRequest;
import com.amazonaws.services.rdsdata.model.ExecuteStatementResult;
import com.amazonaws.services.rdsdata.model.Field;

import java.util.List;
import java.util.Map;

public class Testing implements RequestHandler<Map<String, Object>, String> {

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

        ExecuteStatementRequest request = new ExecuteStatementRequest()
        .withResourceArn(RESOURCE_ARN)
        .withSecretArn(SECRET_ARN)
        .withDatabase("mydb")
        .withSql("select * from mytable");

        ExecuteStatementResult result = rdsData.executeStatement(request);

        for (List<Field> fields: result.getRecords()) {

            String stringValue = fields.get(0).getStringValue();
            long numberValue = fields.get(1).getLongValue();

            System.out.println(String.format("Fetched row: string = %s, number = %d", stringValue, numberValue));

        }

        return "hi";

    }

}
*/