package leetcode.easy.hash_table_all;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/****
 *
 * https://leetcode.com/problems/employee-importance/
 *
 */
public class EmployeeImportance {


    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer,Employee> map = new HashMap();
        for(int i = 0; i < employees.size(); i++)
            map.put(employees.get(i).id,employees.get(i));
        int sum = 0;
        Queue<Employee> q = new LinkedList();
        q.offer(map.get(id));
        while(!q.isEmpty()){
            Employee cur = q.poll();
            sum += cur.importance;
            for(int i = 0; i < cur.subordinates.size(); i++)
                q.offer(map.get(cur.subordinates.get(i)));
        }
        return sum;
    }





// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

}
