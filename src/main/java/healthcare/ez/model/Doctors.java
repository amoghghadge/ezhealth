package healthcare.ez.model;

public class Doctors {
	private String license_no;
	private String last_name;
	private String first_name;
	private String middle_name;
	private String suffix;
	private String license_issue_date;
	private String license_expiration_date;
	private String public_email;
	private String web_site;
	private String pp_prac_name;
	private String pp_address1;
	private String pp_address2;
	private String pp_city;
	private String pp_state;
	private String pp_zip;
	private String pp_telephone;
	private boolean pp_trans_serv_avail;
	private String pp_language_office;
	private String pp_language_practitioner;
	private int pp_percent_location;
	private String pp_days_seen;
	private boolean board_cert;
	private String board_eligible;
	private String self_spec_code;
	private int years_in_us_practice;
	private int years_out_us_practice;
	private boolean medicaid;
	private boolean medicaid_new_patients;
	private boolean medicare;
	private boolean medicare_provider;
	private boolean medicare_new_patients;
	private String hospital_affiliated;
	private String hospital_state;
	private String continue_hours;
	private String continue_date;
	private String lic_status;
	private String flagofnoticeoraction;
	private String grad_school;
	private String grad_school_state;
	private String grad_school_country;
	private String grad_completion;
	private String self_spec;
	private String self_spec_type;

	public Doctors(){
		
	}

	public String getLastName(){
		return last_name;
	}

	public void setLastName(String last_name){
		this.last_name=last_name;
	}

	public String getFirstName(){
		return first_name;
	}

	public void setFirstName(String first_name){
		this.first_name=first_name;
	}

	public String getMiddleName(){
		return middle_name;
	}

	public void setMiddleName(String middle_name){
		this.middle_name=middle_name;
	}

	public String getSuffix(){
		return suffix;
	}

	public void setSuffix(String suffix){
		this.suffix=suffix;
	}

	public String getPublicEmail(){
		return public_email;
	}

	public void setPublicEmail(String public_email){
		this.public_email=public_email;
	}

	public String getWebSite(){
		return web_site;
	}

	public void setWebSite(String web_site){
		this.web_site=web_site;
	}

	public String getPpPracName(){
		return pp_prac_name;
	}

	public void setPpPracName(String pp_prac_name){
		this.pp_prac_name=pp_prac_name;
	}

	public String getPpAddress1(){
		return pp_address1;
	}

	public void setPpAddress1(String pp_address1){
		this.pp_address1=pp_address1;
	}

	public String getPpAddress2(){
		return pp_address2;
	}

	public void setPpAddress2(String pp_address2){
		this.pp_address2=pp_address2;
	}

	public String getPpCity(){
		return pp_city;
	}

	public void setPpCity(String pp_city){
		this.pp_city=pp_city;
	}

	public String getPpState(){
		return pp_state;
	}

	public void setPpState(String pp_state){
		this.pp_state=pp_state;
	}

	public String getPpZip(){
		return pp_zip;
	}

	public void setPpZip(String pp_zip){
		this.pp_zip=pp_zip;
	}

	public String getPpTelephone(){
		return pp_telephone;
	}

	public void setPpTelephone(String pp_telephone){
		this.pp_telephone=pp_telephone;
	}

	public String getPpLanguageOffice(){
		return pp_language_office;
	}

	public void setPpLanguageOffice(String pp_language_office){
		this.pp_language_office=pp_language_office;
	}

	public String getPpLanguagePractitioner(){
		return pp_language_practitioner;
	}

	public void setPpLanguagePractitioner(String pp_language_practitioner){
		this.pp_language_practitioner=pp_language_practitioner;
	}

	public int getPpPercentLocation(){
		return pp_percent_location;
	}

	public void setPpPercentLocation(int pp_percent_location){
		this.pp_percent_location=pp_percent_location;
	}

	public String getPpDaysSeen(){
		return pp_days_seen;
	}

	public void setPpDaysSeen(String pp_days_seen){
		this.pp_days_seen=pp_days_seen;
	}

	public String getBoardEligible(){
		return board_eligible;
	}

	public void setBoardEligible(String board_eligible){
		this.board_eligible=board_eligible;
	}

	public String getSelfSpec(){
		return self_spec;
	}

	public void setSelfSpec(String self_spec){
		this.self_spec=self_spec;
	}

	public int getYearsInUsPractice(){
		return years_in_us_practice;
	}

	public void setYearsInUsPractice(int years_in_us_practice){
		this.years_in_us_practice=years_in_us_practice;
	}

	public int getYearsOutUsPractice(){
		return years_out_us_practice;
	}

	public void setYearsOutUsPractice(int years_out_us_practice){
		this.years_out_us_practice=years_out_us_practice;
	}

	public String getHospitalAffiliated(){
		return hospital_affiliated;
	}

	public void setHospitalAffiliated(String hospital_affiliated){
		this.hospital_affiliated=hospital_affiliated;
	}

	public String getHospitalState(){
		return hospital_state;
	}

	public void setHospitalState(String hospital_state){
		this.hospital_state=hospital_state;
	}

	public String getContinueDate(){
		return continue_date;
	}

	public void setContinueDate(String continue_date){
		this.continue_date=continue_date;
	}

	public String getLicStatus(){
		return lic_status;
	}

	public void setLicStatus(String lic_status){
		this.lic_status=lic_status;
	}

	public String getGradSchool(){
		return grad_school;
	}

	public void setGradSchool(String grad_school){
		this.grad_school=grad_school;
	}

	public String getGradSchoolState(){
		return grad_school_state;
	}

	public void setGradSchoolState(String grad_school_state){
		this.grad_school_state=grad_school_state;
	}

	public String getGradSchoolCountry(){
		return grad_school_country;
	}

	public void setGradSchoolCountry(String grad_school_country){
		this.grad_school_country=grad_school_country;
	}

	public String getGradCompletion(){
		return grad_completion;
	}

	public void setGradCompletion(String grad_completion){
		this.grad_completion=grad_completion;
	}

	public String getLicenseNo() {
		return license_no;
	}

	public void setLicenseNo(String license_no) {
		this.license_no = license_no;
	}

	public String getSelSpecType() {
		return self_spec_type;
	}

	public void setSelfSpecType(String self_spec_type) {
		this.self_spec_type = self_spec_type;
	}

	public String getLicenseIssueDate() {
		return license_issue_date;
	}

	public void setLicenseIssueDate(String license_issue_date) {
		this.license_issue_date = license_issue_date;
	}

	public String getLicenseExpirationDate() {
		return license_expiration_date;
	}

	public void setLicenseExpirationDate(String license_expiration_date) {
		this.license_expiration_date = license_expiration_date;
	}

	public boolean isPpTransServAvail() {
		return pp_trans_serv_avail;
	}

	public void setPpTransServAvail(boolean pp_trans_serv_avail) {
		this.pp_trans_serv_avail = pp_trans_serv_avail;
	}

	public boolean isBoardCert() {
		return board_cert;
	}

	public void setBoardCert(boolean board_cert) {
		this.board_cert = board_cert;
	}

	public String getSelfSpecCode() {
		return self_spec_code;
	}

	public void setSelfSpecCode(String self_spec_code) {
		this.self_spec_code = self_spec_code;
	}

	public boolean isMedicaid() {
		return medicaid;
	}

	public void setMedicaid(boolean medicaid) {
		this.medicaid = medicaid;
	}

	public boolean isMedicaidNewPatients() {
		return medicaid_new_patients;
	}

	public void setMedicaidNewPatients(boolean medicaid_new_patients) {
		this.medicaid_new_patients = medicaid_new_patients;
	}

	public boolean isMedicare() {
		return medicare;
	}

	public void setMedicare(boolean medicare) {
		this.medicare = medicare;
	}

	public boolean isMedicareProvider() {
		return medicare_provider;
	}

	public void setMedicareProvider(boolean medicare_provider) {
		this.medicare_provider = medicare_provider;
	}

	public boolean isMedicareNewPatients() {
		return medicare_new_patients;
	}

	public void setMedicareNewPatients(boolean medicare_new_patients) {
		this.medicare_new_patients = medicare_new_patients;
	}

	public String getContinueHours() {
		return continue_hours;
	}

	public void setContinueHours(String continue_hours) {
		this.continue_hours = continue_hours;
	}

	public String getFlagofnoticeoraction() {
		return flagofnoticeoraction;
	}

	public void setFlagofnoticeoraction(String flagofnoticeoraction) {
		this.flagofnoticeoraction = flagofnoticeoraction;
	}
}