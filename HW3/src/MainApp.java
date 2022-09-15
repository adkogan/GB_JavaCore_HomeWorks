import java.util.Arrays;

public class MainApp {


    public static void main(String[] args) {

        //task 1
     String[] arr = new String[]{"a", "b", "c", "d","e"};
        System.out.println(Arrays.toString(arr));
        swapElements(arr, 0, 2);


        //task 2
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        System.out.println(appleBox1.getWeight());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        System.out.println(appleBox2.getWeight());



        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        System.out.println(orangeBox.getWeight());
        

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox2.compare(orangeBox));

        appleBox1.transfer(appleBox2);
        System.out.println(appleBox2.compare(orangeBox));

        //orangeBox.add(new Apple()); // does not compile





    }

    private static void swapElements(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a]= arr[b];
        arr[b]=temp;
        System.out.println(Arrays.toString(arr));
    }
}
