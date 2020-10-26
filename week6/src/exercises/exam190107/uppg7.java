package exercises.exam190107;

import java.util.ArrayList;
import java.util.List;

public class uppg7 {
    public static void main(String[] args) {
        new exercises.exam190107.uppg7().program();
    }

    private void program() {

    }

    class Employee{
        private final int id;
        private final String name;


        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /*
    Skriv en klass Office för ett kontor. Ett kontor har ett id, ett antal anställda
    och ett maximalt antal anställda. Id och maximalt antal anställda skall anges
    då ett kontor skapas.
    */

    class Office{
        private final int id;
        private final List<Employee> employees = new ArrayList<>();
        private final int maxEmployees;


        Office(int id, int maxEmployees) {
            this.id = id;
            this.maxEmployees = maxEmployees;
        }

        List<Employee> getEmployees(){
            return employees;
        }

        int getMaxEmployees(){
            return maxEmployees;
        }
    }

    /*
    Skriv en class Company för hela företaget. Ett företag har ett antal kontor
    och anställda. Lägg till en metod relocate(employee, fromOfficeId, toOfficeId)
    som flyttar en anställd från kontoret med id:t fromOfficeId till kontoret med
    toOfficeId. Metoden skall returnera true om flytten lyckades annars false (alla
    villkor för en flytt skall kontrolleras). Alla metoder i appendix är tillåtna.
    */

    class Company{
        private final List<Office> offices = new ArrayList<>();
        private final List<Employee> employees = new ArrayList<>();

        boolean relocate(Employee employee, int fromOfficeId, int toOfficeId){
            Office fromOffice = getOffice(fromOfficeId);
            Office toOffice = getOffice(toOfficeId);
            // If none of the offices is in the list of offices, return false
            if(fromOffice == null || toOffice == null)
                return false;

            if(toOffice.getEmployees().size() == toOffice.getMaxEmployees())
                return false;

            if(fromOffice.getEmployees().contains(employee)){
                fromOffice.getEmployees().remove(employee);
                toOffice.getEmployees().add(employee);
                return true;
            }

            return false;

        }

        private Office getOffice(int fromOfficeId){
            for(Office office : offices){
                if(office.id == fromOfficeId)
                    return office;
            }
            return null;
        }




    }



}
