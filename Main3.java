public class Main3
{
    public static void main(String[] args) {
        int[] arr={3,8,6,7,-2,-8,4,9};
        SegmentTree tree=new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(1,6));//getting sum of elements in this range basically
        tree.update(6,3);
        System.out.println(tree.query(1,6));//getting sum of elements in this range basically after updating 6th index with value 3
    }
}
