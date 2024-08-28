package arrays;

/*
   @author Austin Oyugi
   @since 28/08/2024
   @mail austinoyugi@gmail.com
*/
public class DynamicArray {

    private int[] elementArray;
    private int elementCapacity;
    private int elementSize;

    public DynamicArray(int capacity) {
        this.elementArray = new int[capacity];
        this.elementCapacity = capacity;
        this.elementSize = 0;
    }

    public int get(int i) {
        return elementArray[i];
    }

    public void set(int i, int n) {
        elementArray[i] = n;
    }

    public void pushback(int n) {
        if(elementSize == elementCapacity){
            this.resize();
        }
        elementArray[elementSize] = n;
        elementSize++;
    }

    public int popback() {
        int value = elementArray[elementSize -1];
        elementSize--;
        return value;
    }

    private void resize() {
        elementCapacity *= 2;
        int[] newElementArray = new int[elementCapacity];
        for(int i=0; i<elementArray.length; i++){
            newElementArray[i] = elementArray[i];
        }
        elementArray=newElementArray;
    }

    public int getSize() {
        return elementSize;
    }

    public int getCapacity() {
        return elementCapacity;
    }

    public static void main(String[] args){
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {

        DynamicArray dynamicArray1 = new DynamicArray(1);

        // Expect 0
        System.out.println(dynamicArray1.getSize());
        assert dynamicArray1.getSize() == 0;

        // Expect 1
        System.out.println(dynamicArray1.getCapacity());
        assert dynamicArray1.getCapacity() == 1;
    }

    private static void testCase2() {
        DynamicArray dynamicArray2 = new DynamicArray(1);
        dynamicArray2.pushback(1);

        // Expect 1
        System.out.println(dynamicArray2.getCapacity());
        assert dynamicArray2.getCapacity() == 1;

        dynamicArray2.pushback(2);

        // Expect 2
        System.out.println(dynamicArray2.getCapacity());
        assert dynamicArray2.getCapacity() == 2;
    }

    private static void testCase3() {

        DynamicArray dynamicArray3 = new DynamicArray(1);

        // Expect 0
        System.out.println(dynamicArray3.getSize());
        assert dynamicArray3.getSize() == 0;

        // Expect 1
        System.out.println(dynamicArray3.getCapacity());
        assert dynamicArray3.getCapacity() == 1;

        dynamicArray3.pushback(1);

        // Expect 1
        System.out.println(dynamicArray3.getSize());
        assert dynamicArray3.getSize() == 1;

        // Expect 1
        System.out.println(dynamicArray3.getCapacity());
        assert dynamicArray3.getCapacity() == 1;

        dynamicArray3.pushback(2);

        // Expect 2
        System.out.println(dynamicArray3.getSize());
        assert dynamicArray3.getSize() == 2;

        // Expect 2
        System.out.println(dynamicArray3.getCapacity());
        assert dynamicArray3.getCapacity() == 2;

        // Expect 2
        System.out.println(dynamicArray3.get(1));
        assert dynamicArray3.get(1) == 2;

        dynamicArray3.set(1,3);

        // Expect 3
        System.out.println(dynamicArray3.get(1));
        assert dynamicArray3.get(1) == 3;

        // Expect 3
        int popbackValue = dynamicArray3.popback();
        System.out.println(popbackValue);
        assert popbackValue == 3;

        // Expect 1
        System.out.println(dynamicArray3.getSize());
        assert dynamicArray3.getSize() == 1;

        // Expect 2
        System.out.println(dynamicArray3.getCapacity());
        assert dynamicArray3.getCapacity() == 2;
    }
}
