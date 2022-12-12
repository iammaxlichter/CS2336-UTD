package CS2336.InClass;

class Employee{
    private String name;
    protected double hourlyRate;
    private int hours;

    Employee(String name, double hourlyRate, int hours){
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    public double computePay(){
        return hourlyRate * hours;
    }

    public String getName() {
        return name;
    }

}

class PartTimeEmployee extends Employee{
    PartTimeEmployee(String name, double hourlyRate, int hours) {
        //invokes parent class construct rwith modified parameters
        super(name, hourlyRate, Math.min(hours,30));  
    }

}

class FulltimeEmployee extends Employee{
    FulltimeEmployee(String name, double hourlyRate) {
        super(name, hourlyRate, 40);
    }
}

class NonExemptEmployee extends FulltimeEmployee{
    private int overtimeHours;

    public NonExemptEmployee(String name, double hourlyRate, int hours) {
        super(name, hourlyRate);
        overtimeHours = Math.max(0, hours-40);
    }

    public double computePay(){
        //         fulltime pay   +        pay for overtime hours
        return super.computePay() + 1.5 * overtimeHours * hourlyRate;
    }
}

class ShiftEmployee extends FulltimeEmployee{
    private int shiftNumber;
    ShiftEmployee(String name, double hourlyRate, int shiftNumber) {
        super(name, hourlyRate);
        this.shiftNumber = shiftNumber;
    }

    public double computePay(){
        if (shiftNumber == 2){
            return super.computePay() * 1.05;
        }
        else if (shiftNumber == 3){
            return super.computePay() * 1.10;
        }
        return super.computePay();
    }
}

class SalesEmployee extends FulltimeEmployee{
    private double salesTarget, actual;

    SalesEmployee(String name, double hourlyRate, double salesTarget, double actual) {
        super(name, hourlyRate);
        this.salesTarget = salesTarget;
        this.actual = actual;
    }

    public double computePay(){
            return super.computePay() + .1 * Math.max(0,actual-salesTarget);
        }
    }


public class Company {
    

    public static void main(String[] args){
        Employee employees[] = {
            new PartTimeEmployee("Mark", 10, 25),
            new FulltimeEmployee("Jake", 22.5),
            new NonExemptEmployee("Mick", 11.25, 28),
            new ShiftEmployee("Bill", 15.5, 2),
            new SalesEmployee("Doug", 19.5, 10000, 15000)
        };
        for(Employee e : employees)
            System.out.println(e.getName() + ": " + e.computePay());
    }
}
