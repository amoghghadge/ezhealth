DROP DATABASE ezhealth;
CREATE DATABASE ezhealth;
USE ezhealth;
CREATE TABLE main_table
(
    license_no VARCHAR(10) not null,
    last_name NVARCHAR(50) default null,
    first_name NVARCHAR(50) default null,
    middle_name NVARCHAR(50) default null,
    suffix NVARCHAR(8) default null,
    issue_date DATETIME(4) default null,
    expiration_date DATETIME(4) default null,
    public_email VARCHAR(50) default null,
    web_site VARCHAR(75) default null,
    pp_prac_name NVARCHAR(175) default null,
    pp_address1 NVARCHAR(100) default null,
    pp_address2 NVARCHAR(100) default null,
    pp_city NVARCHAR(50) default null,
    pp_state VARCHAR(20) default null,
    pp_zip VARCHAR(10) default null,
    pp_telephone VARCHAR(20) default null,
    pp_trans_serv_avail TINYINT(1) default null,
    pp_language_office NVARCHAR(255) default null,
    pp_language_practitioner NVARCHAR(255) default null,
    pp_percent_location INT(20) default null,
    pp_days_seen VARCHAR(40) default null,
    board_cert TINYINT(1) default null,
    board_eligible VARCHAR(50) default null,
    self_spec_code VARCHAR(200) default null,
    years_in_us_practice INT(20) default null,
    years_out_us_practice INT(20) default null,
    medicaid TINYINT(1) default null,
    medicaid_new_patients TINYINT(1) default null,
    medicare TINYINT(1) default null,
    medicare_provider TINYINT(1) default null,
    medicare_new_patients TINYINT(20) default null,
    hospital_affiliated VARCHAR(200) default null,
    hospital_state VARCHAR(8000) default null,
    continue_hours REAL(4,0) default null,
    continue_date VARCHAR(10) default null,
    lic_status VARCHAR(25) default null,
    flagofnoticeoraction TINYINT(1) default null,
    grad_school NVARCHAR(150) default null,
    grad_school_state NVARCHAR(75) default null,
    grad_school_country NVARCHAR(50) default null,
    grad_completion VARCHAR(5) default null,
    primary key(license_no)
);

CREATE UNIQUE INDEX idx_license_no ON main_table (license_no);
CREATE INDEX idx_first_name ON main_table (first_name);
CREATE INDEX idx_last_name ON main_table (last_name);
CREATE INDEX idx_pp_prac_name ON main_table (pp_prac_name);
CREATE INDEX idx_pp_zip ON main_table (pp_zip);
CREATE INDEX idx_medicaid on main_table (medicaid);
CREATE INDEX idx_medicare on main_table (medicare);


create table providers_academic_appointments
(
    license_no VARCHAR(10) not null,
    academ_appt VARCHAR(250) default null,
    academ_appt_rank VARCHAR(50) default null,
    academ_appt_years VARCHAR(50) default null,
    primary key(license_no)
);

CREATE UNIQUE INDEX idxpaa_license_no ON providers_academic_appointments (license_no);

create table providers_actions
(
    license_no VARCHAR(10) not null,
    action_type TINYINT(1) default null,
    action_date VARCHAR(50) default null,
    action_entity VARCHAR(255) default null,
    action_taken VARCHAR(600) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxpa_license_no ON providers_actions (license_no);

create table providers_board_certification
(
    license_no VARCHAR(10) not null,
    spec_cert_name VARCHAR(255) default null,
    spec_cert_code VARCHAR(50) default null,
    spec_cert_date VARCHAR(50) default null,
    spec_current TINYINT(1) default null,
    spec_cert_date_exp VARCHAR(50) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxpbc_license_no ON providers_board_certification (license_no);

create table providers_felony
(
    license_no VARCHAR(10) not null,
    conviction_date DATETIME(4) default null,
    conviction_location VARCHAR(10) default null,
    conviction_code VARCHAR(100) default null,
    conviction_description VARCHAR(400) default null,
    conviction_city VARCHAR(75) default null,
    conviction_state VARCHAR(50) default null,
    conviction_country VARCHAR(75) default null,
    conviction_type VARCHAR(30) default null,
    sentence_date INT(4) default null,
    suspended_years INT(4) default null,
    suspended_months INT(4) default null,
    served_years INT(4) default null,
    served_months INT(4) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxpf_license_no ON providers_felony (license_no);

create table providers_honor_awards
(
    license_no VARCHAR(10) not null,
    honor_name VARCHAR(255) default null,
    honor_from VARCHAR(255) default null,
    honor_year VARCHAR(50) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxpha_license_no ON providers_honor_awards (license_no);

create table providers_insurance
(
    license_no VARCHAR(10) not null,
    plan0 VARCHAR(100) default null,
    participate0 TINYINT(1) default null,
    plan1 VARCHAR(100) default null,
    participate1 TINYINT(1) default null,
    plan2 VARCHAR(100) default null,
    participate2 TINYINT(1) default null,
    plan3 VARCHAR(100) default null,
    participate3 TINYINT(1) default null,
    plan4 VARCHAR(100) default null,
    participate4 TINYINT(1) default null,
    plan5 VARCHAR(100) default null,
    participate5 TINYINT(1) default null,
    plan6 VARCHAR(100) default null,
    participate6 TINYINT(1) default null,
    plan7 VARCHAR(100) default null,
    participate7 TINYINT(1) default null,
    plan8 VARCHAR(100) default null,
    participate8 TINYINT(1) default null,
    plan9 VARCHAR(100) default null,
    participate9 TINYINT(1) default null,
    contact_phone VARCHAR(20) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxpi_license_no ON providers_insurance (license_no);


create table providers_malpractice_self_reported
(
    license_no VARCHAR(10) not null,
    malprac_year VARCHAR(50) default null,
    malprac_specialty VARCHAR(250) default null,
    country VARCHAR(155) default null,
    settlement TINYINT(1) default null,
    comments VARCHAR(400) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxpmsr_license_no ON providers_malpractice_self_reported (license_no);

create table providers_post_graduate
(
    license_no VARCHAR(10) not null,
    post_specialty VARCHAR(50) default null,
    post_program VARCHAR(150) default null,
    post_city VARCHAR(50) default null,
    post_country VARCHAR(50) default null,
    post_state VARCHAR(50) default null,
    post_completion VARCHAR(50) default null,
    post_intern TINYINT(1) default null,
    post_resid TINYINT(1) default null,
    post_fellow TINYINT(1) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxppg_license_no ON providers_post_graduate (license_no);

create table providers_practice_address
(
    license_no VARCHAR(10) not null,
    prac_name VARCHAR(175) default null,
    address1 VARCHAR(50) default null,
    address2 VARCHAR(50) default null,
    city VARCHAR(50) default null,
    state VARCHAR(50) default null,
    zip VARCHAR(50) default null,
    telephone VARCHAR(50) default null,
    trans_serv_avail TINYINT(1) default null,
    language_office VARCHAR(255) default null,
    language_practitioner VARCHAR(255) default null,
    percent_location smallINT(2) default null,
    days_seen VARCHAR(50) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxppa_license_no ON providers_practice_address (license_no);

create table providers_publications
(
    license_no VARCHAR(10) not null,
    public_title VARCHAR(255) default null,
    public_journal VARCHAR(255) default null,
    public_html VARCHAR(100) default null,
    public_volume VARCHAR(100) default null,
    public_date VARCHAR(50) default null,
    primary key(license_no)
);
CREATE UNIQUE INDEX idxpp_license_no ON providers_publications (license_no);

create table lookup_academic_rank
(
    id NVARCHAR(10) not null,
    rank_description NVARCHAR(50) default null,
    primary key(id)
);

create table lookup_foreign_language
(
    language_id NVARCHAR(10) not null,
    language_description NVARCHAR(255) default null,
    primary key(language_id)
);

create table lookup_hospital
(
    id NVARCHAR(10) not null,
    hospital NVARCHAR(150) default null,
    primary key(id)
);

create table lookup_school
(
    id NVARCHAR(10) not null,
    school_name NVARCHAR(150) default null,
    school_type NVARCHAR(3) default null,
    primary key(id)
);

create table lookup_self_designate_specialty
(
    id NVARCHAR(10),
    specialty NVARCHAR(150),
    specialty_type NVARCHAR(3),
    primary key(id)
);

create table lookup_specialty
(
    id NVARCHAR(10),
    specialty_name NVARCHAR(150),
    specialty_type NVARCHAR(5),
    primary key(id)
);

create table lookup_specialty_malpractice
(
    id NVARCHAR(50),
    specialty NVARCHAR(255),
    primary key(id)
);