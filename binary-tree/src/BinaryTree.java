
class Node {
    int value;
    Node left;
    Node right;

    Node (int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class BinaryTree {

    Node root;

    public void add(int value) {
        root = addValue(root, value);
    }

    private Node addValue(Node current, int value) {
        if (current == null) {
            current = new Node(value);
            return current;
        }

        if (value < current.getValue()) current.setLeft(addValue(current.getLeft(), value));

        if (value > current.getValue()) current.setRight(addValue(current.getRight(), value));

        return current;
    }

    public void orderTree() {
        order(root);
    }

    private void order(Node root) {
        if (root != null) {
            order(root.getLeft());
            System.out.println(root.getValue() + " ");
            order(root.getRight());
        }
    }

    private Node remove(Node node, int value) {
        if (node != null) {
            if (value < node.getValue()) node.setLeft(remove(node.getLeft(), value));

            if (value > node.getValue()) node.setRight(remove(node.getRight(), value));

            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            node.setRight(remove(node.getRight(), node.getValue()));
        }

        return node;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(13);
        binaryTree.add(19);
        binaryTree.add(3);
        binaryTree.add(21);
        binaryTree.add(5);

        binaryTree.remove(binaryTree.root, 3);

        binaryTree.orderTree();
    }
}