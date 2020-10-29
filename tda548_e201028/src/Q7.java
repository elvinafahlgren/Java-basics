import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.List;

/*
        Solution to question 7 here.
 */
public class Q7 {

    public static void main(String[] args) {
        new Q7().program();
    }

    private void program() {
        // No need to call anything here.
        // But feel free to run your own tests if you want.
    }

    // TODO add classes and methods

    class Document {
        private final String title;
        private final String createdDate;
        private final int rank;


        Document(String title, String createdDate, int rank) {
            this.title = title;
            this.createdDate = createdDate;
            this.rank = rank;
        }

        int getRank(){
            return rank;
        }

        String getTitle(){
            return title;
        }
    }

    class Person {
        private final String name;
        private final int rank;

        Person(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }


        boolean canRead(Document document){
            if(rank >= document.getRank())
                return true;
            return false;
        }

        String getName(){
            return name;
        }


    }

    class ACM {
        private final List<Document> documents = new ArrayList<>();
        private final List<Person> people = new ArrayList<>();

        void printMatrix(){
            for(Document document : documents) {
                System.out.print(document.getTitle() + " ");
            }
            System.out.println();

            for(Person person : people){
                System.out.print(person.getName() + " ");
                for(Document document : documents){
                    System.out.print(person.canRead(document) + " ");
                }
                System.out.println();
            }
        }
    }
}
