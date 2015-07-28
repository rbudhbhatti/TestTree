public class Main {

    public static void main(String[] args) {

        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node root = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        //Node n7 = new Node(7);

        TestTree b1 = new TestTree(3);
        b1.add(root,n2,"left");
        b1.add(n2,n1,"left");
        b1.add(n2,n0,"right");
        b1.add(root,n4,"right");
        b1.add(root,n5,"right");
        b1.add(n5,n6,"right");
        //b1.add(n6,n7,"left");

        BTreePrinter bp = new BTreePrinter();

        bp.printNode(root);

//        System.out.println("Inorder Traverse");
//        b1.inorderTraverse(root);
//        System.out.println("Preorder Traverse");
//        b1.preorderTraverse(root);
//        System.out.println("Postorder Traverse");
//        b1.postorderTraverse(root);

//        System.out.println("depthFirstQueue");
//        b1.depthFirstTraverse(root);

//        System.out.println("Check if Tree is balanced:" + b1.isBalanced(root));

        System.out.println("Nodes on each level, using two queues");
        b1.nodesOnLevelQueue(root);

//        System.out.println("Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth");
//        b1.findNodesOnLevel(root);

        System.out.println("Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given node in a binary search tree where each node has a link to its parent");
        b1.findSuccessor(n4);
    }
}



