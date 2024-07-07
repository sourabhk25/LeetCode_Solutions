# Write your MySQL query statement below
SELECT m.name
FROM Employee m
JOIN 
(SELECT ManagerId 
FROM Employee
GROUP BY ManagerId
HAVING COUNT(ManagerId) >= 5) as e
ON m.id = e.ManagerId;