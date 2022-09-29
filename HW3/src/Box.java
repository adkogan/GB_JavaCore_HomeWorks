import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> elements = new ArrayList<>();


  public void add(T element){
      elements.add(element);
  }

  public float getWeight(){
      float totalWeight = 0;
      for (T element : elements) {
          totalWeight += element.getWeight();
      }
      return totalWeight;
  }


  public boolean compare(Box other){
      return this.getWeight()==other.getWeight();
  }

  public void transfer(Box<T> target){
      for (T element : elements) {
          target.add(element);
      }
      elements.clear();
  }




}
