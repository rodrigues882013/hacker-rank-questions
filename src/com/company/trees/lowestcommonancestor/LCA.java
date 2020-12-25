package com.company.trees.lowestcommonancestor;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LCA {
    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        Node runnerLeft = root;
        Node runnerRight = root;
        Node leastCommon = root;
        //Node runner = root;

        while (runnerRight != null && runnerLeft == runnerRight) {
            leastCommon = runnerLeft;

            if (v1 > runnerLeft.data) {
                runnerLeft = runnerLeft.right;
            } else if (v1 < runnerLeft.data) {
                runnerLeft = runnerLeft.left;
            }

            if (v2 > runnerRight.data) {
                runnerRight = runnerRight.right;
            } else if (v2 < runnerRight.data) {
                runnerRight = runnerRight.left;
            }


            //runnerLeft = v1 > runnerLeft.data ? runnerLeft.right : runnerLeft.left;
            //runnerRight = v2 > runnerRight.data ? runnerRight.right : runnerRight.left;
        }

        return leastCommon;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = null;
//        int[] values = new int[]{4, 2, 3, 1, 7, 6};
        //int[] values = new int[]{1, 2};
        //int[] values = new int[]{8, 4, 9, 1, 2, 3, 6, 5};
        int[] values = new int[]{23, 16, 15, 9, 6, 17, 10, 13, 8, 26, 18, 2, 22, 24, 12, 5, 20, 25, 21, 4, 19, 1, 3, 14, 7};



        for (int elem : values) {
            root = insert(root, elem);
        }
        int v1 = 23;
        int v2 = 3;
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}
