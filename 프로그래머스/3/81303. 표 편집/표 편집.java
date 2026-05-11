import java.util.*;

class Solution {
    
    class Node {
        Node prev = null;
        Node next = null;
        boolean isDeleted;
        
        public Node up(int count){
            Node node = this;
            for(int i = 0 ; i < count ; i++){
                node = node.prev;
            }
            return node;
        }
        
        public Node down(int count){
            Node node = this;
            for(int i = 0 ; i < count ; i++){
                node = node.next;
            }
            return node;
        }
        
        public Node clear(){
            this.isDeleted = true;
            Node prev = this.prev;
            Node next = this.next;
            
            if(prev != null){
                prev.next = next;
            }
            if(next != null){
                next.prev = prev;
                // 삭제한 행의 바로 아래행 선택
                return next;
            }
            // 삭제한 행이 맨 마지막일 경우 그 위의 행 선택
            return prev;
        }
        
        public void undo(){
            this.isDeleted = false;
            Node prev = this.prev;
            Node next = this.next;
            
            if(prev != null){
                prev.next = this;
            }
            if(next != null){
                next.prev = this;
            }
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        // n : 행의 개수 , k : 처음 선택된 행의 위치, cmd : 명령어
        Node[] nodes = new Node[n];
        Deque<Node> undoStack = new ArrayDeque<>();
        
        for(int i = 0; i < n ; i++){
            nodes[i] = new Node();
            
            // 맨 첫번째 노드는 head 이기 때문에 prev가 없어도 됨
            if(i == 0){
                continue;
            }
            nodes[i].prev = nodes[i - 1];
            nodes[i - 1].next = nodes[i];
        }
        
        Node current = nodes[k];
        
        StringTokenizer st;
        for(String c : cmd){
            st = new StringTokenizer(c);
            String command = st.nextToken();
            
            switch(command){
                case "U":
                    int count = Integer.parseInt(st.nextToken());
                    current = current.up(count);
                    break;
                case "D" :
                    count = Integer.parseInt(st.nextToken());
                    current = current.down(count);
                    break;
                case "C" :
                    undoStack.push(current);
                    current = current.clear();
                    break;
                case "Z" :
                    Node undoNode = undoStack.pop();
                    undoNode.undo();
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Node node : nodes){
            if(!node.isDeleted){
                sb.append("O");
            }else{
                sb.append("X");
            }
        }
        
        return sb.toString();
    }
}