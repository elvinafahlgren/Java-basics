package exercises.exam191030;

import java.util.ArrayList;
import java.util.List;

public class uppg7 {
    public static void main(String[] args) {
        new exercises.exam191030.uppg7().program();
    }

    private void program() {
    }


    enum Type { REAL, PERSONAL, NOMINAL } // Type for Account
    public class Person { // Class for customers
        private final String id;
        private String name;
        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }
// getter/setter, equals, hashCode omitted (but exists)
    }

    /*
    Skriv en klass Account f¨or ett bankkonto. Ett konto har ett id, en typ och
    ett belopp. Id och typ skall anges d˚a man skapar ett kontoobjekt. Vi antar 2p
    att alla setters/getters/equals/hashCode vi ev. beh¨over finns (g¨aller ¨aven
    nedan).
     */

    class Account {
        private final int id;
        private final Type type;
        private int balance;

        Account(int id, Type type) {
            this.id = id;
            this.type = type;
        }
    }
    /*
    Skriv en klass Association som kopplar ihop ett konto (Account) med en kund
    (Person). Konto och kund skall anges d˚a man skapar ett objekt.
     */
    class Association {
        private final Account account;
        private final Person person;


        Association(Account account, Person person) {
            this.account = account;
            this.person = person;
        }
    }

    /*
    Skriv en klass Bank. En bank har ett antal kunder, ett antal konton och
    en lista med associationer mellan kunder och konton. L¨agg till en metod 5p
    createAccount som givet en kund och en kontotyp skapar ett nytt konto och
    kopplar ihop kunden med med kontot. Om detta lyckas s˚a finns kontot och
    associationen sparade i banken och metoden returnerar true. Misslyckas det
    returneras false. Ni kan anta att det finns en metod long getUniqueAccoutnNumber() som ger ett unikt kontonummer. F¨oljande restriktioner g¨aller:
    Kunden m˚aste finnas i banken. En kund f˚ar bara ha ett konto av varje typ.
    */

    class Bank {
        private final List<Person> customers = new ArrayList<>();
        private final List<Account> accounts = new ArrayList<>();
        private final List<Association> associations = new ArrayList<>();

        boolean createAccount(Person person, Type type){
            if(!customers.contains(person))
                return false;

            return false;
        }
    }
}
