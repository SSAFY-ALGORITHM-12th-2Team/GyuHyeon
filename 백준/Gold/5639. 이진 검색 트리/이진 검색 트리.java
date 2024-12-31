import java.util.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] pre = new int[10001];
        int size = 0;
        while (true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) break;
            pre[size++] = Integer.parseInt(str);
        }
        Node root = new Node(pre[0]);
        Stack<Node> s = new Stack<>();
        s.push(root);
        int i = 0;
        while (++i < size) {
            Node cur = null;
            while (!s.isEmpty() && pre[i] > s.peek().val) cur = s.pop();
            if (cur != null) {
                cur.right = new Node(pre[i]);
                s.push(cur.right);
            } else {
                s.peek().left = new Node(pre[i]);
                s.push(s.peek().left);
            }
        }
        post(root);
    }
    static void post(Node node) {
        if (node.left != null) post(node.left);
        if (node.right != null) post(node.right);
        System.out.println(node.val);
    }
}