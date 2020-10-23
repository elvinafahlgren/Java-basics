package exercises.exam200107;

public class uppg3 {
    public static void main(String[] args) {
        new exercises.exam200107.uppg3().program();
    }

    private void program() {

    }


    //från genomgång
    int[] expand(int[] arr){
        int[] resultat = new int[getExpandedLength(arr)];
        int resultatIndex = 0;

        resultat[0] = arr[0];
        resultatIndex++;

        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[i]; j++){
                resultat[resultatIndex] = arr[i + 1];
                resultatIndex++;
            }
        }

        return resultat;
    }

    //vet ej om rätt
    int getExpandedLength(int[] arr){
        int sum = 1;
        for(int i = 1; i < arr.length; i++){
            sum++;
        }
        sum += arr[0];
        return sum;
    }
}


