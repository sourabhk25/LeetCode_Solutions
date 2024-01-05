# Write your MySQL query statement below
SELECT contest_id, IFNULL(ROUND(COUNT(contest_id) * 100/ (SELECT COUNT(*) FROM Users), 2), 0) AS percentage
FROM Register 
GROUP BY contest_id
ORDER BY percentage DESC, contest_id ASC;