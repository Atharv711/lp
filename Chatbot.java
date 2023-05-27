import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Scanner;

public class Chatbot {
    public static void main (String[] args){
        System.out.println("Hi I am chat bot. How may I help you? " + LocalDateTime.now());
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] function = {"yearly","monthly","balance enquiry","other services","bye","exit" };
        boolean valid=false;
        for(String func: function){
            if(userInput.equalsIgnoreCase(func)){
                    valid = true;
            }
        }

        if(valid==true){
            switch(userInput){
                case "yearly": int id = yearly(scanner);
                System.out.println("Recharged with option "+id+" successfully on "+LocalDateTime.now());
                break;

            }
        }
        else{
            System.out.println("Invalid function"+" Select from ");
            for(String func : function){
                System.out.println(func);
            }
        }
    }
    private static int yearly(Scanner scanner){
        System.out.println(LocalDateTime.now());
        System.out.println("1.3999 -> 365 days 5gb/day");
        System.out.println("2.2999 -> 365 days 2gb/day");
        System.out.println("Enter your choice ");
        int id = scanner.nextInt();
        return id;
    }
}
