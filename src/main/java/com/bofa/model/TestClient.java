package com.bofa.model;

public class TestClient {

    public TestClient(){
    }

//    perform arithmetic operators
    public static void performArithmeticOps(int a, int b){
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+(a*b));
        System.out.println("a/b="+(a/b));
    }

    public static void performAssignmentOps(int a, int b){
        a += b;
        b += a;
        System.out.println("a = "+ a + ", b = "+b);
    }

    public static void performRelationalOps(int a, int b){
        System.out.println("a == b: "+ (a == b));
        System.out.println("a != b: "+ (a != b));
        System.out.println("a < b: "+ (a < b));
        System.out.println("a > b: "+ (a > b));
        System.out.println("a <= b: "+ (a <= b));
        System.out.println("a >= b: "+ (a >= b));
    }

    public static void performLogicalOps(int a, int b){
//        && operator
        System.out.println((a<b) && (b > a));
        System.out.println((a>b) && (b < a));
//        || operator
        System.out.println((a<b) || (b > a));
        System.out.println((a>b) || (b < a));

        /*! Operator */
        System.out.println(!(a == a));
        System.out.println(!(a<b));
    }



    public static void main(String[] args) {
//        Print the empty client
        Client emptyClient = new Client();

//        Print the client with all the parameters
        Client client1 = new Client(1, "Raj", "test@example.com", "address", 2349234234L, "Male");
        System.out.println(client1.clientName + " is the client name "+ "With "+client1.clientId);

//        Perform arithmetic operators
        int a = 10, b = 20;
        performArithmeticOps(a, b);
//        Perform Relational operators
        performRelationalOps(a, b);

//        Perform Assignment Operators
        performAssignmentOps(a,b);

//        Perform Logical Operators
        performLogicalOps(a,b);
    }

}
