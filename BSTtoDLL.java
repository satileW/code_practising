import java.util.Stack;

/**
 * Created by user on 1/26/17.
 */
public class BSTtoDLL {
//
//    static TreeNode previous;
//    static TreeNode dllHead;
//    //inorder traversal
//    static void BSTtoDLL(TreeNode root){
//        if(root == null) return;
//        BSTtoDLL(root.left);
//        if(this.previous == null){
//            this.dllHead = root;
//            this.previous = root;//this is not essentials
//        }else {
//            root.right = this.previous;
//            this.previous.left = root;
//        }
//        this.previous = root;
//        BSTtoDLL(root.right);
//    }
//    class TreeNode{
//        int val;
//        TreeNode left, right;
//        public TreeNode(int v){
//            this.val = v;
//        }
//    }
//    class DllNode{
//        int val;
//        DllNode next, previous;
//        public DllNode(int v){
//            this.val = v;
//        }
//    }
//    public DllNode BstToDll(TreeNode root){
//        DllNode dummy = new DllNode(0);
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        DllNode dllNode = dummy;
//        TreeNode node = root;
//        while(!stack.isEmpty()){
//            while (node!=null&&node.left!=null){//node.left is important, make the stack without null tree node
//                stack.push(node);
//                node = node.left;
//            }
//            TreeNode now = stack.pop();
//            DllNode dllNow = new DllNode(now.val);
//            dllNode.next = dllNow;
//            dllNow.previous = dllNode;
//
//            dllNode = dllNode.next;
//            if(now.right!=null){
//                stack.push(now.right);
//            }
//            node = now.right;
//        }
//
//        return dummy.next;
//    }
}
