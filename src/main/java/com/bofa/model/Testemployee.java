package com.bofa.model;

public class Testemployee {
    public static void main(String[] args) {
        Employees Emp1=new Employees("Bofa41001", "qweer", "poiuy","5-162 East","xyz@gmail.com",1234567890,"male",100000);
        Employees Emp2=new Employees("Bofa41002", "asdf", "lkjh","5-162 west","pks@gmail.com",1235467890,"male",200000);

        System.out.println(Emp1==Emp2);
        System.out.println((Emp1.getSalary()>Emp2.getSalary())? Emp1.getSalary():Emp2.getSalary());


        String a1=Emp1.getFirstName(),b1=Emp1.getLastName();
        String a2=Emp2.getFirstName(),b2=Emp2.getLastName();
        System.out.println(((a1.equals(a2)) && (b1.equals(b2)))? "Both employees have same name": "They have different names");


        Emp2.setFirstName("qweer");
        Emp2.setLastName("poiuy");
        String a3=Emp2.getFirstName(),b3=Emp2.getLastName();
        System.out.println(Emp2.getFirstName()+" "+Emp2.getLastName());
        System.out.println(((a1.equals(a3)) && (b1.equals(b3)))? "Both employees have same name": "They have different names");


        long newsalary=Emp1.getSalary();
        newsalary+=Emp2.getSalary();
        Emp1.setSalary(newsalary);
        System.out.println(Emp1.getSalary());

        System.out.println(Emp1.toString());
        System.out.println(Emp2.toString());
    }
}
