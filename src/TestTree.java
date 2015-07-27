import java.util.*;

import static java.lang.Math.min;

class TestTree {

    private static Node root;

    public TestTree(int data) {root = new Node(data);}

    public void add(Node parent, Node child, String orientation){
        if(orientation == "left") {
            parent.setLeft(child);
        }else {
            parent.setRight(child);
        }
    }

    public void inorderTraverse(Node root) {
        if(root == null){
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.data);
        inorderTraverse(root.right);
    }

    public void preorderTraverse(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public void postorderTraverse(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data);
        postorderTraverse(root.right);
        postorderTraverse(root.left);
    }

    public void depthFirstTraverse(Node root) {
        Queue queue = new LinkedList();

        ArrayList arrayList = new ArrayList();

        Node traverse;
        if(root == null){
            return;
        }
        queue.add(root);
        System.out.print(root.data);
        while(!queue.isEmpty()){
            traverse = (Node) queue.remove();
            if(traverse.left!= null){
                queue.add(traverse.left);
                System.out.print(traverse.left.getData().toString());
            }
            if(traverse.right!=null){
                queue.add(traverse.right);
                System.out.print(traverse.right.getData().toString());

            }
        }

    }
    public int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int minDepth(Node root){
        if(root == null){
            return 0;
        }
        return 1+  Math.min(minDepth(root.left), minDepth(root.right));
    }

    public boolean isBalanced(Node root){
        if(maxDepth(root) - minDepth(root) <=1 ){
            return true;
        }else
        {
            return false;
        }
    }

    public ArrayList<LinkedList<Node>> findNodesOnLevel(Node root){
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        int level = 0;
        LinkedList list = new LinkedList();
        list.add(root);
        result.add(level,list);
        System.out.println("level" + result.get(level).element().data);
        while(true){
            list = new LinkedList<Node>();
            for(int i=0; i<result.get(level).size(); i++){
                Node n = result.get(level).get(i);
                if(n!= null){
                    if(n.left!=null) list.add(n.left);
                    if(n.right!= null) list.add(n.right);
                }
                if(list.size() > 0){
                    result.add(level+1,list);
                    System.out.println("level" + result.get(level).element().data + " List" + list);
                }else {
                    break;
                }
                level++;
            }
            System.out.println("Level" + result.get(level) + " Nodes" + list.element());
            return result;
        }
    }

    public void nodesOnLevelQueue(Node root) {
        LinkedList<Node> current = new LinkedList<Node>();
        LinkedList<Node> childQueue = new LinkedList<Node>();
        int level = 0;
        if(root == null){
            return;
        }
        current.add(root);
        while(!current.isEmpty()){
            for(int i=0; i< current.size(); i++){
                Node n = current.get(i);
                if(n.left!=null) childQueue.add(n.left);
                if(n.right!=null) childQueue.add(n.right);
                current.remove(i);
            }
            if(current.isEmpty()){
                level = level+1;
                current.addAll(childQueue);
                childQueue.clear();
            }
        }

    }
}