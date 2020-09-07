import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: N_aryTreePreorderTraversal
 * @Description: N叉树的前序遍历
 * @Author: pug
 * @Date: 2020/8/18 15:15
 * @Version: 1.0
 */
public class N_aryTreePreorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root != null){
            res.add(root.val);
            int size = root.children.size();
            for(int i=0; i<size; i++){
                preorder(root.children.get(i));
            }
        }
        return res;
    }

}
