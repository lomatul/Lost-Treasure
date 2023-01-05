package src.setup;
import java.util.*;

public class RandomGenerator {
    public ArrayList<Integer> RandObjIndices;

    ArrayList<Integer> indexes;
    int TotalNumberOfObjects;
    public RandomGenerator(int TotalNumberOfObjects){
        this.TotalNumberOfObjects = TotalNumberOfObjects;
        indexes = new ArrayList<>();
        RandObjIndices = new ArrayList<>();
        for(int i=0; i<TotalNumberOfObjects; i++){
            indexes.add(i);
        }
    }

    public void createUnique(){
        Random random = new Random();
        ArrayList<Integer> indexCopy = indexes;
        while (RandObjIndices.size()!=6){
            int randomIndex = random.nextInt(TotalNumberOfObjects);
            TotalNumberOfObjects--;
            RandObjIndices.add(indexCopy.get(randomIndex));
            indexCopy.remove(randomIndex);
        }
    }
}
