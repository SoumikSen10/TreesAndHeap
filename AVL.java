public class AVL
{
    public class Node
    {
        private int value;
        private Node left;
        private Node right;
        private int height;
        public Node(int value)
        {
            this.value=value;
        }

        public int getValue()
        {
            return value;
        }
    }

    private Node root;

    public AVL()
    {

    }

    public int height()
    {
        return height(root);
    }

    private int height(Node node)
    {
        if(node==null)
        {
            return -1;
        }
        return node.height;
    }

    public void insert(int value)
    {
        root= insert(root,value);
    }

    private Node insert(Node node,int value)
    {
        if(node==null)
        {
            return new Node(value);
        }
        if(value<node.value)
        {
            node.left=insert(node.left,value);
        }
        if(value>node.value)
        {
            node.right=insert(node.right,value);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }

    private Node rotate(Node node)
    {
        if(height(node.left)-height(node.right)>1)
        {
            //left heavy
            if(height(node.left.left)-height(node.left.right)>0)
            {
                // left-left case
                return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0)
            {
                //left-right case
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left)-height(node.right)<-1)
        {
            //right heavy
            if(height(node.right.left)-height(node.right.right)<0)
            {
                //right-right case
                return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)>0)
            {
                //right-left case
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node rightRotate(Node parent)
    {
        Node child=parent.left;
        Node t=child.right;

        child.right=parent;
        parent.left=t;

        parent.height=Math.max(height(parent.left),height(parent.right)+1);
        child.height=Math.max(height(child.left),height(child.right)+1);

        return child;
    }

    public Node leftRotate(Node child)
    {
        Node parent=child.right;
        Node t=parent.left;

        parent.left=child;
        child.right=t;

        parent.height=Math.max(height(parent.left),height(parent.right)+1);
        child.height=Math.max(height(child.left),height(child.right)+1);
        return parent;
    }

    public void populate(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        {
            this.insert(nums[i]);
        }
    }

    public void populatedSort(int[] nums)
    {
        populatedSort(nums,0,nums.length);
    }

    private void populatedSort(int[] nums,int start,int end)
    {
        if(start>=end)
        {
            return;
        }
        int mid=(start+end)/2;
        this.insert(nums[mid]);
        populatedSort(nums,start,mid);
        populatedSort(nums,mid+1,end);
    }

    public void display()
    {
        display(this.root,"Root Node is: ");
    }

    private void display(Node node,String details)
    {
        if(node==null)
        {
            return;
        }
        System.out.println(details+node.value);
        display(node.left,"Left child of: "+node.value+" : ");
        display(node.right,"Right child of: "+node.value+" : ");
    }

    public boolean isEmpty()
    {
        return root==null;
    }

    public boolean isBalanced()
    {
        return isBalanced(root);
    }
    private boolean isBalanced(Node node)
    {
        if(node==null)
            return true;
        return Math.abs(height(node.left)-height(node.right))<=1 && isBalanced(node.left) && isBalanced(node.right);
    }
}
