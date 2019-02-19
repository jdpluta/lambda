package com.jdp.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.jdp.lambda.Employee;

class FullTimeEmployee extends Employee {
	// Declaring an Optional container which can hold Passport object
	private Optional<Passport> passport = Optional.empty(); // The container is initially empty
	public Optional<Passport> getPassport() {
		return passport;
	}
	public void setPassport(Optional<Passport> passport) {
		this.passport = passport;
	}
	// Other fields and methods
	
	public static List<FullTimeEmployee> getFullTimeEmpList() {
		FullTimeEmployee india = new FullTimeEmployee();
		india.setEmpId(1);
		india.setEmpName("Mitul Patel");
		india.setCountry("India");
		india.setRole("Employee");
		india.setSal(100.00);
		india.setYearsInOrg(1);
		Passport p = new Passport();
		p.setPassportNo(111);
		india.setPassport(Optional.of(p));
		FullTimeEmployee usa = new FullTimeEmployee();
		usa.setEmpId(2);
		usa.setEmpName("John Doe");
		usa.setCountry("USA");
		usa.setRole("Manager");
		usa.setSal(200.00);
		usa.setYearsInOrg(1);
		FullTimeEmployee poland = new FullTimeEmployee();
		poland.setEmpId(3);
		poland.setEmpName("Jan Kozak");
		poland.setCountry("Poland");
		poland.setRole("Manager");
		poland.setSal(300.00);
		poland.setYearsInOrg(2);
		p = new Passport();
		p.setPassportNo(222);
		poland.setPassport(Optional.ofNullable(p));
		FullTimeEmployee england = new FullTimeEmployee();
		england.setEmpId(4);
		england.setEmpName("George Smith");
		england.setCountry("England");
		england.setRole("Employee");
		england.setSal(400.00);
		england.setYearsInOrg(3);
		p = new Passport();
		england.setPassport(Optional.of(p));
		FullTimeEmployee s[] = { india, usa, poland, england };
		List<FullTimeEmployee> empList = Arrays.asList(s);
		return empList;
	}
}

class Passport {
	private int passportNo;
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	// Other fields and methods
}

public class EmployeeStarter {
	public static void main(String[] args) {
		List<FullTimeEmployee> empList = FullTimeEmployee.getFullTimeEmpList();
		List<Integer> passNums = new ArrayList<Integer>();
		for (FullTimeEmployee e : empList) {
			Optional<FullTimeEmployee> optEmp = Optional.ofNullable(e);
			passNums.add(optEmp.flatMap(FullTimeEmployee::getPassport).map(Passport::getPassportNo).orElse(0));
		}
		
		passNums.forEach(System.out::println);
	}
}
