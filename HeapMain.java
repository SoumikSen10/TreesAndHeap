import java.util.ArrayList;
import java.util.Scanner;
class HeapMain {
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new Heap<>();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the length of your array: ");
        int n=in.nextInt();
        System.out.println("Enter the elements in your array: ");
        for(int i=0;i<n;i++)
        {
            heap.insert(in.nextInt());
        }
        ArrayList list = heap.heapSort();
        System.out.println(list);

    }
}