/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> emap;    //map to put id and employee
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for(Employee e: employees) {
            emap.put(e.id, e);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = emap.get(id);   //get that employee
        int ans = employee.importance;  //get importance in ans
        for(int subid: employee.subordinates) {
            ans += dfs(subid);  //call dfs on subid
        }
        return ans;
    }
}