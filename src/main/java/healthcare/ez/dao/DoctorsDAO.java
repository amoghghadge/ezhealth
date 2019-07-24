package healthcare.ez.dao;

import java.util.*;

import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteStatementRequest;
import com.amazonaws.services.rdsdata.model.ExecuteStatementResult;
import com.amazonaws.services.rdsdata.model.Field;

import healthcare.ez.model.Doctors;

public class DoctorsDAO {

	public static List<Doctors> searchAllDoctors(String RESOURCE_ARN, String SECRET_ARN) {
		
		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from providers");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		int numOfRecords = result.getRecords().size();
		System.out.println();
		System.out.println("Number of Records:");
		System.out.println(numOfRecords);
		System.out.println();

		List<Doctors> doctors = new ArrayList<Doctors>();

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			Doctors doctor = new Doctors();
			String self_spec = idToSpecialty(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpec(self_spec);
			String self_spec_type = idToType(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpecType(self_spec_type);
			doctor.setLicenseNo(fields.get(0).getStringValue());
			doctor.setLastName(fields.get(1).getStringValue());
			doctor.setFirstName(fields.get(2).getStringValue());
			doctor.setMiddleName(fields.get(3).getStringValue());
			doctor.setSuffix(fields.get(4).getStringValue());
			doctor.setPublicEmail(fields.get(7).getStringValue());
			doctor.setWebSite(fields.get(8).getStringValue());
			doctor.setPpPracName(fields.get(9).getStringValue());
			doctor.setPpAddress1(fields.get(10).getStringValue());
			doctor.setPpAddress2(fields.get(11).getStringValue());
			doctor.setPpCity(fields.get(12).getStringValue());
			doctor.setPpState(fields.get(13).getStringValue());
			doctor.setPpZip(fields.get(14).getStringValue());
			doctor.setPpTelephone(fields.get(15).getStringValue());
			doctors.add(doctor);
		}

		return doctors;

	}

	//TO-DO: Set up the date and insurance
	public static List<Doctors> searchByName(String RESOURCE_ARN, String SECRET_ARN, String last_name, String first_name, String pp_prac_name, String pp_zip, String city, String date, String insurance) {

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from providers where last_name = '" + last_name +"' or first_name = '" + first_name + "' or pp_zip = '" + pp_zip +
		"' or pp_prac_name = '" + pp_prac_name + "' or city = '" + city + "'");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		int numOfRecords = result.getRecords().size();
		System.out.println();
		System.out.println("Number of Records:");
		System.out.println(numOfRecords);
		System.out.println();

		List<Doctors> doctors = new ArrayList<Doctors>();

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			Doctors doctor = new Doctors();
			String self_spec = idToSpecialty(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpec(self_spec);
			String self_spec_type = idToType(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpecType(self_spec_type);
			doctor.setLicenseNo(fields.get(0).getStringValue());
			doctor.setLastName(fields.get(1).getStringValue());
			doctor.setFirstName(fields.get(2).getStringValue());
			doctor.setMiddleName(fields.get(3).getStringValue());
			doctor.setSuffix(fields.get(4).getStringValue());
			doctor.setPublicEmail(fields.get(7).getStringValue());
			doctor.setWebSite(fields.get(8).getStringValue());
			doctor.setPpPracName(fields.get(9).getStringValue());
			doctor.setPpAddress1(fields.get(10).getStringValue());
			doctor.setPpAddress2(fields.get(11).getStringValue());
			doctor.setPpCity(fields.get(12).getStringValue());
			doctor.setPpState(fields.get(13).getStringValue());
			doctor.setPpZip(fields.get(14).getStringValue());
			doctor.setPpTelephone(fields.get(15).getStringValue());
			doctors.add(doctor);
		}

		return doctors;

	}

	// TO-DO: Set up date and insurance
	public static List<Doctors> searchBySpecialty(String RESOURCE_ARN, String SECRET_ARN, String specialty, String pp_prac_name, String pp_zip, String city, String date, String insurance) {

		String id = specialtyToId(RESOURCE_ARN, SECRET_ARN, specialty);

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from providers where self_spec_code = '" + id + "' or pp_zip = '" + pp_zip + "' or pp_prac_name = '" + pp_prac_name + "' or city = '" + city + "'");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		int numOfRecords = result.getRecords().size();
		System.out.println();
		System.out.println("Number of Records:");
		System.out.println(numOfRecords);
		System.out.println();

		List<Doctors> doctors = new ArrayList<Doctors>();

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			Doctors doctor = new Doctors();
			String self_spec = idToSpecialty(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpec(self_spec);
			String self_spec_type = idToType(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpecType(self_spec_type);
			doctor.setLicenseNo(fields.get(0).getStringValue());
			doctor.setLastName(fields.get(1).getStringValue());
			doctor.setFirstName(fields.get(2).getStringValue());
			doctor.setMiddleName(fields.get(3).getStringValue());
			doctor.setSuffix(fields.get(4).getStringValue());
			doctor.setPublicEmail(fields.get(7).getStringValue());
			doctor.setWebSite(fields.get(8).getStringValue());
			doctor.setPpPracName(fields.get(9).getStringValue());
			doctor.setPpAddress1(fields.get(10).getStringValue());
			doctor.setPpAddress2(fields.get(11).getStringValue());
			doctor.setPpCity(fields.get(12).getStringValue());
			doctor.setPpState(fields.get(13).getStringValue());
			doctor.setPpZip(fields.get(14).getStringValue());
			doctor.setPpTelephone(fields.get(15).getStringValue());
			doctors.add(doctor);
		}

		return doctors;

	}	

	//TO-DO: Set up date and insurance
	public static List<Doctors> searchByCondition(String RESOURCE_ARN, String SECRET_ARN, String condition, String pp_prac_name, String pp_zip, String city, String date, String insurance) {

		String specialty = conditionToSpecialty(RESOURCE_ARN, SECRET_ARN, condition);
		String id = specialtyToId(RESOURCE_ARN, SECRET_ARN, specialty);

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from providers where self_spec_code = '" + id + "' or pp_zip = '" + pp_zip + "' or pp_prac_name = '" + pp_prac_name + "' or city = '" + city + "'");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		int numOfRecords = result.getRecords().size();
		System.out.println();
		System.out.println("Number of Records:");
		System.out.println(numOfRecords);
		System.out.println();

		List<Doctors> doctors = new ArrayList<Doctors>();

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			Doctors doctor = new Doctors();
			String self_spec = idToSpecialty(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpec(self_spec);
			String self_spec_type = idToType(RESOURCE_ARN, SECRET_ARN, fields.get(23).getStringValue());
			doctor.setSelfSpecType(self_spec_type);
			doctor.setLicenseNo(fields.get(0).getStringValue());
			doctor.setLastName(fields.get(1).getStringValue());
			doctor.setFirstName(fields.get(2).getStringValue());
			doctor.setMiddleName(fields.get(3).getStringValue());
			doctor.setSuffix(fields.get(4).getStringValue());
			doctor.setPublicEmail(fields.get(7).getStringValue());
			doctor.setWebSite(fields.get(8).getStringValue());
			doctor.setPpPracName(fields.get(9).getStringValue());
			doctor.setPpAddress1(fields.get(10).getStringValue());
			doctor.setPpAddress2(fields.get(11).getStringValue());
			doctor.setPpCity(fields.get(12).getStringValue());
			doctor.setPpState(fields.get(13).getStringValue());
			doctor.setPpZip(fields.get(14).getStringValue());
			doctor.setPpTelephone(fields.get(15).getStringValue());
			doctors.add(doctor);
		}

		return doctors;

	}

	private static String idToSpecialty(String RESOURCE_ARN, String SECRET_ARN, String id) {

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from lookup_self_designate_specialty where id = '" + id + "'");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		String specialty = "";

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			
			specialty = fields.get(1).getStringValue();

		}

		return specialty;
	
	}

	private static String idToType(String RESOURCE_ARN, String SECRET_ARN, String id) {

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from lookup_self_designate_specialty where id = '" + id + "'");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		String specialty_type = "";

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			
			specialty_type = fields.get(2).getStringValue();

		}

		return specialty_type;

	}

	private static String specialtyToId(String RESOURCE_ARN, String SECRET_ARN, String specialty) {

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from lookup_self_designate_specialty where specialty like '%" + specialty + "%'");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		String id = "";

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			
			id = fields.get(0).getStringValue();

		}

		return id;
		
	}

	public static String conditionToSpecialty(String RESOURCE_ARN, String SECRET_ARN, String condition) {

		AWSRDSData rdsData = AWSRDSDataClient.builder().build();

		ExecuteStatementRequest request = new ExecuteStatementRequest()
		.withResourceArn(RESOURCE_ARN)
		.withSecretArn(SECRET_ARN)
		.withDatabase("ezhealth")
		.withSql("select * from patient_conditions where condition like '%" + condition + "%'");

		ExecuteStatementResult result = rdsData.executeStatement(request);

		String specialty = "";

		for (List<Field> fields : result.getRecords()) { // TO-DO: Read in all the data into the
			
			specialty = fields.get(1).getStringValue();

		}

		return specialty;

	}

	/*
	 * public static Providers[] search() {
	 * 
	 * AWSRDSData rdsData = AWSRDSDataClient.builder().build();
	 * 
	 * ExecuteStatementRequest request = new ExecuteStatementRequest()
	 * .withResourceArn(RESOURCE_ARN) .withSecretArn(SECRET_ARN)
	 * .withDatabase("ezhealth") .withSql("select * from providers");
	 * 
	 * ExecuteStatementResult result = rdsData.executeStatement(request);
	 * 
	 * int numOfRecords = result.getRecords().size(); System.out.println();
	 * System.out.println("Number of Records:"); System.out.println(numOfRecords);
	 * System.out.println();
	 * 
	 * Providers[] doctors = new Providers[numOfRecords]; int count = 0;
	 * 
	 * for (int i = 0; i < doctors.length; i++) {
	 * 
	 * doctors[i] = new Providers();
	 * 
	 * }
	 * 
	 * for (List<Field> fields : result.getRecords()) { //TO-DO: Read in all the
	 * data into the
	 * 
	 * doctors[count].setLicenseNo(fields.get(0).getStringValue());
	 * doctors[count].setLastName(fields.get(1).getStringValue());
	 * doctors[count].setFirstName(fields.get(2).getStringValue());
	 * doctors[count].setMiddleName(fields.get(3).getStringValue());
	 * doctors[count].setSuffix(fields.get(4).getStringValue());
	 * doctors[count].setPublicEmail(fields.get(7).getStringValue());
	 * doctors[count].setWebSite(fields.get(8).getStringValue());
	 * doctors[count].setPpPracName(fields.get(9).getStringValue());
	 * doctors[count].setPpAddress1(fields.get(10).getStringValue());
	 * doctors[count].setPpAddress2(fields.get(11).getStringValue());
	 * doctors[count].setPpCity(fields.get(12).getStringValue());
	 * doctors[count].setPpState(fields.get(13).getStringValue());
	 * doctors[count].setPpZip(fields.get(14).getStringValue());
	 * doctors[count].setPpTelephone(fields.get(15).getStringValue());
	 * 
	 * count++;
	 * 
	 * }
	 * 
	 * return doctors;
	 * 
	 * }
	 */
	
}
