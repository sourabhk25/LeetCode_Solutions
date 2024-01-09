# Write your MySQL query statement below
# UNION clause - find employees with Y UNION employees having employee_id of count 1
SELECT employee_id, department_id 
FROM Employee
WHERE primary_flag = 'Y'
UNION
SELECT employee_id, department_id 
FROM Employee
GROUP BY employee_id
HAVING COUNT(employee_id) = 1;