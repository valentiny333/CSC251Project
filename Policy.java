import java.util.Scanner;

public class Policy // this class models an insurance policy for one person.
{ // attributes
   private int policyNumber;
   private String providerName;
   private String policyHolderFirstName;
   private String policyHolderLastName;
   private int policyHolderAge;
   private String smokingStatus;
   private int height; // in inches
   private int weight; // in pounds
   
   // no-arg constructor 
   public Policy() 
   {
      policyNumber = 0;
      providerName = "Unknown";
      policyHolderFirstName = "Unknown";
      policyHolderLastName = "Unknown";
      policyHolderAge = 0;
      smokingStatus = "non-smoker";
      height = 0;
      weight = 0; 
   }
   
   public Policy(int num, String provider, String first,
                 String last, int age, String smoker, int h, int w)// constructor with parameters
   {
      policyNumber = num;
      providerName = provider;
      policyHolderFirstName = first;
      policyHolderLastName = last;
      policyHolderAge = age;
      smokingStatus = smoker;
      height = h;
      weight = w;
   }
   
   // accessor methods
   public int getPolicyNumber()
   {
      return policyNumber;
   }
   
   public String getProviderName()
   {
      return providerName;
   }
   
   public String getPolicyHolderFirstName()
   {
      return policyHolderFirstName;
   }
   
   public String getPolicyHolderLastName()
   {
      return policyHolderLastName;
   }
   
   public int getPolicyHolderAge()
   {
      return policyHolderAge;
   }
   
   public String getSmokingStatus()
   {
      return smokingStatus;
   }
   
   public int getHeight()
   {
      return height;
   }
   
   public int getWeight()
   {
      return weight;
   }
   
   // calculate BMI
   public double getBMI()
   {
      return (weight * 703.0) / (height * height);
   }
   
   //calculate insurance price
   public double getInsurancePrice()
   {
      double price = 600;
      
      if(policyHolderAge > 50)
      {
         price += 75;
      }
      if(smokingStatus.equals("smoker"))
      {
         price += 100;
      }
      if(getBMI() > 35)
      {
         price += (getBMI() - 35) * 20;
      }
      
      return price;
   }
   
   public static void main(String[] args)// main method
   {
      Scanner keyboard = new Scanner(System.in);
      
      // get user input
      System.out.print("Enter Policy Number: ");
      int policyNumber = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("Enter Provider Name: ");
      String providerName = keyboard.nextLine();

      System.out.print("Enter Policyholder's First Name: ");
      String firstName = keyboard.nextLine();

      System.out.print("Enter Policyholder's Last Name: ");
      String lastName = keyboard.nextLine();

      System.out.print("Enter Policyholder's Age: ");
      int age = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("Enter Policyholder's Smoking Status (smoker/non-smoker): ");
      String smokingStatus = keyboard.nextLine();

      System.out.print("Enter Policyholder's Height (in inches): ");
      int height = keyboard.nextInt();

      System.out.print("Enter Policyholder's Weight (in pounds): ");
      int weight = keyboard.nextInt();

      // create Policy object
      Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

      // display policy details
      System.out.println("\nPolicy Information:");
      System.out.println("Policy Number: " + policy.getPolicyNumber());
      System.out.println("Provider Name: " + policy.getProviderName());
      System.out.println("Policyholder First Name: " + policy.getPolicyHolderFirstName());
      System.out.println("Policyholder Last Name: " + policy.getPolicyHolderLastName());
      System.out.println("Policyholder Age: " + policy.getPolicyHolderAge());
      System.out.println("Policyholder Smoking Status: " + policy.getSmokingStatus());
      System.out.println("Policyholder Height: " + policy.getHeight() + " inches");
      System.out.println("Policyholder Weight: " + policy.getWeight() + " pounds");
      System.out.printf("Policyholder BMI: %.2f\n", policy.getBMI());
      System.out.printf("Policy Price: $%.2f\n", policy.getInsurancePrice());
   }
}
   
   