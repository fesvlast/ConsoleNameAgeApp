package ua.fesvlast;

import ua.fesvlast.bean.Person;

import java.util.List;

/**
 * Created by Tim on 27.09.2014.
 */
public class UtilPeople {

    private List<Person> people;

    public UtilPeople(List<Person> people){
        this.people =people;
    }

    public int getMinAge(){
        int temp=people.get(0).getAge();
        for(int i=0; i<people.size()-1; i++){
           temp=Math.min(temp,people.get(i+1).getAge());
        }
        return temp;
    }

    public int getMaxAge(){
        int temp=people.get(0).getAge();
        for(int i=0; i<people.size()-1; i++){
            temp=Math.max(temp,people.get(i+1).getAge());
        }
        return temp;
    }

    public double getAverageAge(){
        double average=0.0;

        for(Person person :people)
            average+=person.getAge();

        average=average/people.size();
        return average;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
