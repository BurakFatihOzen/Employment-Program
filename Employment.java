import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name=input.nextLine();
        System.out.print("Please enter your salary: ");
        double salary=input.nextDouble();
        System.out.print("Please enter your work hour: ");
        int workHour=input.nextInt();
        System.out.print("Please enter your hire year: ");
        int hireYear=input.nextInt();

        Employee emp=new Employee(name,salary,workHour,hireYear);
        emp.toString(emp);


    }
}//Main Class


import java.util.Scanner;

public class Employee {
    String name;
    Double salary;
    int workHour;
    int hireYear;

    Employee(String name,Double salary,int workHour,int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHour = workHour;
        this.hireYear = hireYear;
    }

    public double Tax(){
        double tax=0.0;
        if(this.salary<=1000)
            tax=0;

        else if(this.salary>1000)
            tax = this.salary * 0.03;

        return tax;
    }

    public double Bonus(){
        double bonus;
        if(this.workHour<40)
            bonus=0;
        else
            bonus=(workHour-40)*30;

        return bonus;
    }

    public double RaiseSalary(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the current year:");
        int currentYear=input.nextInt();
        int workYear=currentYear-hireYear;
        double raiseSalary=0.0;

        if(workYear<10)
            raiseSalary=this.salary*0.05;

        else if(workYear>9 && workYear<20)
            raiseSalary=this.salary*0.10;

        else if(workYear>19)
            raiseSalary=this.salary*0.15;

        return raiseSalary;
    }
    public void toString(Employee emp) {
        System.out.println("Name: "+name);
        System.out.println("Salary: "+salary);
        System.out.println("Work Hour: "+workHour);
        System.out.println("Hire Year: "+hireYear);
        System.out.println("Bonus: "+Bonus());
        System.out.println("RaiseSalary: "+RaiseSalary());
        System.out.println("Salary with tax and bonus:"+(salary+Bonus()-Tax()));
        System.out.println("Salary with tax bonus and raise of salary:"+(salary+Bonus()-Tax()+RaiseSalary()));
}

}//Employee Class
