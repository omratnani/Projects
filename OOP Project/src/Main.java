import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<NewPerson> Personslist = new ArrayList<NewPerson>();
    public static void main(String[] args)
    {
        System.out.println("********Persons detail SysTem*******");
        System.out.println("-----------------------------");
        System.out.println(" ");
        System.out.println("=========Enter Your Login Details==========");
        Scanner scan = new Scanner(System.in);
        Self a = new Self("12", "12", "12");
        System.out.println("Your Name : ");
        String Name = scan.nextLine();
        if (a.getName().equals(Name))
        {

            String Email, Password;
            System.out.println("Enter Your Email : ");
            Email = scan.nextLine();
            System.out.println("Enter Your Password : ");
            Password = scan.nextLine();
            if (a.getEmail().equals(Email) && a.getPassword().equals(Password)) {
                System.out.println("Sucessfully Logged In");
                System.out.println("-----------------------------");
                int userinput;
                do {
                    System.out.println("1: Add Information of a person");
                    System.out.println("2: Show Existing Details of a Person");
                    System.out.println("0: Exit Program");
                    System.out.print("Choose your option: ");
                    userinput = scan.nextInt();
                    switch (userinput)
                    {
                        case 1:
                            Addinfo();
                            break;
                        case 2:
                            showinfo();
                            break;
                    }
                }while (userinput!=0);

            }
            else
            {
                System.out.println("Password/Email Wrong Either");
            }

        }
       else
        {
            System.out.println("Incorrect Name");
        }
    }

     public static void showinfo()
     {
         System.out.println("---------- My List ----------");
         for (int i=0;i<Personslist.size();i++)
         {
             int count=i+1;
             System.out.println("***Person "+(count)+"****");
             System.out.println("Name of the person: "+Personslist.get(i).Name);
             System.out.println("Event Date: "+Personslist.get(i).date);
             System.out.println("Event Place: "+Personslist.get(i).place);
             System.out.println("How did you meet? "+Personslist.get(i).howMet);
             System.out.println("Your Views about that person: "+Personslist.get(i).experience);
             System.out.println("************************************************");

         }
     }
      public static void Addinfo()
      {
        Scanner scanner=new Scanner(System.in);
        NewPerson obj=new NewPerson();
          System.out.println("Enter Name of that person: ");
          obj.Name= scanner.nextLine();
          System.out.println("Enter Event date: ");
          obj.date=scanner.nextLine();
          System.out.println("Enter Event Place: ");
          obj.place=scanner.nextLine();
          System.out.println("Enter how did you Meet: ");
          obj.howMet=scanner.nextLine();
          System.out.println("Enter your Experience about the person: ");
          obj.experience=scanner.nextLine();
          int x,j=101;

          //calculating total number of added information
          x= Personslist.size()+1;
          System.out.println("Number of information added: "+x);
          if (Personslist.size()>0)
          {

              for (int i=0;i<Personslist.size();i++)
              {
                  if (Personslist.get(i).Name.equals(obj.Name))
                  {
                      j=i;
                  }
              }
          }
          if (j!=101)
          {
              System.out.println("Friend Already Exist: "+ obj.Name);
          }
          Personslist.add(obj);

          FileHandling FH = new FileHandling();
          FH.CreateFile("ABC.txt");
          FH.WriteObjectOnFile(obj);

    }
}















