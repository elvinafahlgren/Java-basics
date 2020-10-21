package exercises.lecture;

public class LateEarlyBind {
    public static void main(String[] args){new LateEarlyBind().program();}

    private void program(){
        A a = new C();
        // doIt override:as inte i C. parametrarna i doIt i A och C är olika - det blir TIDIG BINDNING
        // kompilatorn talar direkt om att A har en doIt-metod som matchar input-värdet 5
        a.doIt(5);
        // kompilatorn vet inte här om den skall använde metoden i A eller C eftersom de har samma parametar och samma
        // namn - det blir SEN BINDNING. runtime får lösa det. Eftersom objeketet är C kommer doOther i C att köras!
        a.doOther(5);
    }

    public class A{
        public void doIt(double d){
            System.out.println("DoIt A double " + d);
        }
        public void doOther(int i){
            System.out.println("DoOther A int " + i);
        }
    }
    public class C extends A{
        public void doIt(int i){
            System.out.println("DoIt C int " + i);
        }
        public void doOther(int i){
            System.out.println("DoOther C int " + i);
        }
    }
}
