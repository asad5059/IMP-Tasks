import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class customer
{
   String firstName,lastName,city,stateCode,postCode,phone,mail,ip;
   boolean isValid = true;
   boolean validatePhoneNumber(String phoneNumber)
   {
       // Remove any non-digit characters from the phone number string
       String cleanedNumber = phoneNumber.replaceAll("\\D", "");

       char firstDigit = cleanedNumber.charAt(0);
       //removing country code
       if(firstDigit=='1')
       {
           cleanedNumber = cleanedNumber.substring(1,cleanedNumber.length());
       }

       if (cleanedNumber.length() != 10) {
           return false;
       }

       // All checks passed, so the phone number is valid
       return true;
   }
    boolean validateEmail(String email) {

        // Check that the email has exactly one @ character
        int atSymbolCount = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                atSymbolCount++;
            }
        }
        if (atSymbolCount != 1) {
            return false;
        }

        // Check that the email does not start or end with a period
        if (email.charAt(0) == '.' || email.charAt(email.length() - 1) == '.') {
            return false;
        }

        // Check that the email contains only valid characters
        String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.@";
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (validChars.indexOf(c) == -1) {
                return false;
            }
        }

        // Check that the email contains at least one period and one non-period character after the @ symbol
        int atSymbolIndex = email.indexOf('@');
        String afterAtSymbol = email.substring(atSymbolIndex + 1);
        if (afterAtSymbol.indexOf('.') == -1 || afterAtSymbol.indexOf('.') == afterAtSymbol.length() - 1) {
            return false;
        }

        // All checks passed, the email is valid
        return true;
    }
   customer(String cus)
   {
       //indicates the columns of the data
       //col-1 : firstName, col-2:lastName ...
       int columnNo = 1;
       //tmp will split the strings by ,
       String tmp="";
       for(int i=0;i<cus.length();i++)
       {
           char ch = cus.charAt(i);
           //if comma is found then it means we are at the end of some data
           if(ch==',')
           {
               //if columnNo = 1, it is first name
               if(columnNo==1)
               {
                   firstName = tmp;
               }
               //if columnNo = 2, it is city

               if(columnNo==2)
               {
                   lastName = tmp;
               }
               //if columnNo = 3, it is last name
               if(columnNo==3)
               {
                    city = tmp;
               }
               //if columnNo = 4, it is state code
               if(columnNo==4)
               {
                   stateCode = tmp;
               }
               //if columnNo = 5, it is post code
               if(columnNo==5)
               {
                   postCode = tmp;
               }
               //if columnNo = 6, it is phone no
               if(columnNo==6)
               {
                    if(validatePhoneNumber((tmp)))
                    {
                        phone=tmp;
                    }
                    else{
                        isValid = false;
                        break;
                    }
               }
               //if columnNo = 7, it is mail
               if(columnNo==7)
               {
                   if(validateEmail(tmp))
                   {
                       mail = tmp;
                   }
                   else{
                       isValid = false;
                       break;
                   }
               }
               //if columNo = 8, it is ip
               if(columnNo==8){
                   ip = tmp;
               }

               //resetting the tmp
               tmp = "";
               //pointing to the next column
               columnNo++;
           }
           else{
               tmp+=ch;
           }
       }

   }

}
public  class customerHandlerThread extends Thread{
    int validWriter = 1, invalidWriter = 1;
    String filenameValid = "valid"+validWriter+".txt";
    String filenameInvalid = "invalid"+invalidWriter+".txt";
    @Override
    public void run()
    {
        try {
            int limit = 10000,szOfInv = 0, szOfVal = 0;

            Set<String> st = new HashSet<>();

            Scanner scanner = new Scanner(new File("1M-customers.txt"));
            PrintWriter valWriter = new PrintWriter(new File(filenameValid));
            PrintWriter invalWriter = new PrintWriter(new File(filenameInvalid));
            while(scanner.hasNextLine())
            {


                String tmp = scanner.nextLine();
                customer c = new customer(tmp);
                if(c.isValid)
                {
                    String temp = c.mail+c.phone;
                    //checking if the data is already in valid set.
                    boolean duplicateFound = st.contains(temp);
                    if(!duplicateFound) {
                        valWriter.println(tmp);
                        //all valid data goes to set
                        st.add(temp);
                        szOfVal++;
                        if(szOfVal==limit)
                        {
                            szOfVal=0;
                            valWriter.close();
                            validWriter+=1;
                            filenameValid = "valid"+validWriter+".txt";
                            valWriter = new PrintWriter(new File(filenameValid));
                        }
                    }
                    //if it is already in set we ignore it.
                }
                else {
                    invalWriter.println(tmp);
                    szOfInv++;
                    if(szOfInv==limit)
                    {
                        szOfInv=0;
                        invalWriter.close();
                        invalidWriter+=1;
                        filenameInvalid = "invalid"+invalidWriter+".txt";
                        invalWriter = new PrintWriter(new File(filenameInvalid));

                    }
                }
            }
            scanner.close();
            valWriter.close();
            invalWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
