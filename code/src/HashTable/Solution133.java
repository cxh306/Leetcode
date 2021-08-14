package HashTable;

import util.Node;

import java.util.*;

public class Solution133 {

    /**
     * BFS
     * @param node
     * @return
     */
    public Node cloneGraph1(Node node) {
        if(node==null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        Map<Integer,Node> map = new HashMap<>();
        queue.push(node);
        map.put(node.val,new Node(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node top = queue.removeLast();
            for (Node neighbor : top.neighbors) {
                if(!map.containsKey(neighbor.val)){
                    map.put(neighbor.val,new Node(neighbor.val,new ArrayList<>()));
                    queue.addFirst(neighbor);
                }
                map.get(top.val).neighbors.add(map.get(neighbor.val));
            }
        }
        return map.get(node.val);
    }

    /**
     * DFSasdasdasdasdsadasd
     */
    Map<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        //已访问
        if(map.containsKey(node)) return map.get(node);

        //未访问,克隆该节点
        Node node1 = new Node(node.val, new ArrayList<>());

        //加入访问集合
        map.put(node,node1);

        //处理其邻
        for (Node neighbor : node.neighbors) {
            node1.neighbors.add(cloneGraph(neighbor));
        }
        return node1;
    }
}
