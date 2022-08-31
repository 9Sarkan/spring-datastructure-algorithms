package com.datastructure.demo.service.tree;


public class BinarySearchTree extends TreeTraversal {
    public BinarySearchTree(int data){
        super(data);
    }

    public void insert(int data){
        this.setRoot(insert(this.root(), data));
    }  

    private Node insert(Node root, int data){
        if (root == null){
            root = new Node(data, null, null);  
            return root;
        }
        if (root.GetData() > data){
            root.left = insert(root.GetLeft(), data);
            return root;
        }
        if (root.GetData() < data){
            root.right = insert(root.GetRight(), data);
            return root;
        }
        root.increaseCount();
        return root;
    }

    public void delete(int data){
        setRoot(delete(root(), data));
    }

    private Node delete(Node root, int data){
        if (root == null){
            return root;
        }
        if (root.GetData() > data){
            root.left = delete(root.GetLeft(), data);
            return root;
        }
        if (root.GetData() < data){
            root.right = delete(root.GetRight(), data);
            return root;
        }

        // data is equal to current node
        int currentCount = root.decreaseCount();

        // if there is not any instance of that data remove the node
        if (currentCount <= 0) {
            // in this situation we have 3 case
            // case 1, node is a leaf, so we just remove it
            if (root.GetLeft() == null && root.GetRight() == null){
                return null;
            }

            // case 2, node has single child
            if (root.GetLeft() != null && root.GetRight() == null){
                return root.GetLeft();
            }
            if (root.GetLeft() == null && root.GetRight() != null){
                return root.GetRight();
            }

            // case 3, node has 2 children => 
            // Get the inorder successor of that node
            // Replace the node with the inorder successor.
            // Remove the inorder successor from its original position.
            Node inorderSuccessor = findMinimum(root.GetRight());
            inorderSuccessor.SetRight(
                delete(root.GetRight(), inorderSuccessor.GetData())
            );
            inorderSuccessor.SetLeft(root.GetLeft());
            return inorderSuccessor; 
        }

        return root;
    }

    public Node search(int data){
        return search(root(), data);
    }

    private Node search(Node root, int data){
        if (root == null){
            return null;
        }
        if (root.GetData() > data){
            return search(root.GetLeft(), data);
        }
        if (root.GetData() < data){
            return search(root.GetRight(), data);
        }
        return root;
    }

    public Node findMinimum(Node root){
        if (root.GetLeft() != null){
            return findMinimum(root.GetLeft());
        }
        return root;
    }

    
}
