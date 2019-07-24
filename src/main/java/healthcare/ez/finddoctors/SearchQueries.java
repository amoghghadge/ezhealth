package healthcare.ez.finddoctors;

import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteStatementRequest;
import com.amazonaws.services.rdsdata.model.ExecuteStatementResult;
import com.amazonaws.services.rdsdata.model.Field;

import healthcare.ez.dao.DoctorsDAO;
import healthcare.ez.model.Doctors;
import healthcare.ez.Credentials;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.List;
import java.util.Map;

public class SearchQueries implements RequestHandler <Map <String, Object>, List<Doctors>> {

    //public static String RESPONSE = "";
    
    public static void main(String[] args) {
        
        System.out.println("Hello");

    }

    public List<Doctors> handleRequest(Map<String, Object> input, Context context) {

        Credentials credentials = new Credentials();
        String RESOURCE_ARN = credentials.getResourceArn();
        String SECRET_ARN = credentials.getSecretArn();

        //From the first box (Condition, procedure, doctor name..)
        String last_name = input.getOrDefault("last_name", "NULL").toString();
        String first_name = input.getOrDefault("first_name", "NULL").toString();
        String specialty = input.getOrDefault("specialty", "NULL").toString();
        String condition = input.getOrDefault("condition", "NULL").toString();
        String pp_prac_name = input.getOrDefault("pp_prac_name", "NULL").toString();
        
        //From the second box (Zip code or City)
        String pp_zip = input.getOrDefault("pp_zip", "NULL").toString();
        String city = input.getOrDefault("city", "NULL").toString();

        //From the third box (Appointment Date)
        String date = input.getOrDefault("date", "NULL").toString();

        //From the fourth box (Insurance)
        String insurance = input.getOrDefault("insurance", "NULL").toString();    

        //RESPONSE = search(RESOURCE_ARN, SECRET_ARN, last_name, first_name, specialty, condition, pp_prac_name, pp_zip, city, date, insurance);

        if (specialty != "NULL") {

            return DoctorsDAO.searchBySpecialty(RESOURCE_ARN, SECRET_ARN, specialty, pp_prac_name, pp_zip, city, date, insurance);

        } else if (condition != "NULL") {

            return DoctorsDAO.searchByCondition(RESOURCE_ARN, SECRET_ARN, condition, pp_prac_name, pp_zip, city, date, insurance);

        } else if (last_name == "NULL" && first_name == "NULL" && pp_prac_name == "NULL" && pp_zip == "NULL" && city == "NULL" && date == "NULL" && 
        insurance == "NULL"){

            return DoctorsDAO.searchAllDoctors(RESOURCE_ARN, SECRET_ARN);

        } else {

            return DoctorsDAO.searchByName(RESOURCE_ARN, SECRET_ARN, last_name, first_name, pp_prac_name, pp_zip, city, date, insurance);

        }

        //return RESPONSE;

    }

    public static String search (String RESOURCE_ARN, String SECRET_ARN, String last_name, String first_name, String specialty, String condition, String pp_prac_name, String pp_zip, String city,
    String date, String insurance) {

        AWSRDSData rdsData = AWSRDSDataClient.builder().build();

        ExecuteStatementRequest request = new ExecuteStatementRequest()
        .withResourceArn(RESOURCE_ARN)
        .withSecretArn(SECRET_ARN)
        .withDatabase("ezhealth")
        .withSql("select * from providers");

        ExecuteStatementResult result = rdsData.executeStatement(request);

        for (List<Field> fields : result.getRecords()) {

            

            String stringValue = fields.get(0).getStringValue();
            //long numberValue = fields.get(1).getLongValue();

            System.out.println();
            System.out.println("All fields:");
            System.out.println(fields);
            System.out.println();
            System.out.println("1st fields:");
            System.out.println(fields.get(0));
            System.out.println();
            System.out.println("String value:");
            System.out.println(stringValue);
            System.out.println();
            System.out.println("Something else:");
            System.out.println(result.getGeneratedFields());
            System.out.println();

            //System.out.println(numberValue);

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
