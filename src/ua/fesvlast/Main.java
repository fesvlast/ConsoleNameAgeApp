package ua.fesvlast;

import ua.fesvlast.bean.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("This application allow to input list of person's parameters (First Name, Last Name, Age):\n");
        System.out.print("Enter <EXIT> to output the result and escape from the application.\n");


        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        List<Person> people =new ArrayList<Person>();
        String delim =new String("/.\\, ");
        while(true){
            System.out.print("Enter First Name, Last Name, Age: (Use space or comma to separate data):\n");
            String str=reader.readLine();
            if(str.equalsIgnoreCase("exit"))break;

            StringTokenizer token =new StringTokenizer(str, delim);

            if(token.countTokens()==3){
                System.out.println("OK");

                Person person =new Person();

                try{
                    person.setFirstName(token.nextToken());
                    person.setLastName(token.nextToken());
                    int age=Integer.valueOf(token.nextToken());

                    if(age<0 || age>150 ){
                        throw new IncorrectAgeException();
                    }
                    person.setAge(age);
                    people.add(person);
                }catch (NumberFormatException e){
                   System.out.println("You should input int number as age!");
                    person=null;
                }catch (IncorrectAgeException e){
                    System.out.println("Age should be more than 0 and less than 150!");
                    person=null;
                }
            }else{
                System.out.println("Incorrect data format! Try again");
            }
        }

        for(Person person :people)
            System.out.println(person);

        UtilPeople util =new UtilPeople(people);
        Formatter formAverageAge =new Formatter();
        formAverageAge.format("%3.2f", util.getAverageAge());

        System.out.println("Min age: "+util.getMinAge()+" | Max age: "+util.getMaxAge()+" | Average Age: "+formAverageAge);


    }


}
