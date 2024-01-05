# Write your MySQL query statement below
SELECT m.name
FROM Employee m
JOIN 
(SELECT ManagerId 
FROM Employee
GROUP BY ManagerId
HAVING COUNT(ManagerId) >= 5) as e
WHERE m.id = e.ManagerId;