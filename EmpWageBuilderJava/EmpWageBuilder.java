
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class EmpWageBuilder{
	//Constants
	private final int IS_FULL_TIME=1;
	private final int IS_PART_TIME=2;
	//variables
	private final String companyName;
	private final int empRate;
	private final int maxWorkingDays;
	private final int maxWorkingHours;
	private static Dictionary wagesOfCompany = new Hashtable();
		
	public EmpWageBuilder(CompanyEmpWage company){
		this.companyName=company.companyName;
		this.empRate=company.empRate;
		this.maxWorkingDays=company.maxWorkingDays;
		this.maxWorkingHours=company.maxWorkingHours;
	}

	public int checkAttendace(){
		int fulldayHours=8,halfadayHours=4,isAbscent=0;
		int empCheck=(int)Math.floor(Math.random()*10)%3;
		switch(empCheck) {
				case IS_FULL_TIME:
					return fulldayHours;
				case IS_PART_TIME:
					return halfadayHours;
				default:
					return isAbscent;
			}

	}
	
	public static void calculateEmployeeWage(ArrayList<CompanyEmpWage> companiesList) {
		for(CompanyEmpWage company:companiesList) {
			new EmpWageBuilder(company).calculateEmployeeWageForCompany();
		}
	}
	
	public  void calculateEmployeeWageForCompany(){
		
		int totalWorkingHours=0,totalWorkingDays=0,totalEmpWage=0;
		
		while (totalWorkingHours<maxWorkingHours && totalWorkingDays<maxWorkingDays)
		{
			int empHours=checkAttendace();
			int empWage=empHours*empRate;
			totalWorkingDays++;
			totalWorkingHours+=empHours;
			totalEmpWage+=empWage;
		}
		wagesOfCompany.put(companyName,totalEmpWage);
	}
	public static String getTotalWage(String company) {
		return wagesOfCompany.get(company).toString();
	}
	public static void main(String[] args){
		ArrayList<CompanyEmpWage> companiesList=new ArrayList<CompanyEmpWage>();
		companiesList.add(new CompanyEmpWage("DMart",20,2,20));
		companiesList.add(new CompanyEmpWage("Amazon",30,6,20));
		calculateEmployeeWage(companiesList);
		getTotalWage("DMart");
	}

}
