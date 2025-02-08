import java.util.HashMap;
import java.util.PriorityQueue;

public class DesginNumberContainer{
    HashMap<Integer,PriorityQueue<Integer>> res;
    HashMap<Integer,Integer> index_val;

    public DesginNumberContainer() {
        res = new HashMap<>();
        index_val = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(index_val.containsKey(index)){
            int num = index_val.get(index);
            if(num == number){
                return ;
            }
            res.get(num).remove(index);
        }
        
        res.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        index_val.put(index, number);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> pq = res.getOrDefault(number, new PriorityQueue<>());
        if(pq.size() == 0) {
            return -1;
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        // Create an instance of the DesginNumberContainer class
        DesginNumberContainer container = new DesginNumberContainer();
        
        // Demonstrating the `change` method
        container.change(1, 10);
        container.change(2, 20);
        container.change(3, 10);
        container.change(4, 30);
        
        // Demonstrating the `find` method
        System.out.println(container.find(10));  // Should return the smallest index for number 10, which is 1
        System.out.println(container.find(20));  // Should return the smallest index for number 20, which is 2
        System.out.println(container.find(30));  // Should return the smallest index for number 30, which is 4
        System.out.println(container.find(40));  // Should return -1 since number 40 doesn't exist in the container
    }
}
