# Write your MySQL query statement below
SELECT e.name
FROM Employee as e
JOIN Employee as m
ON e.id = m.managerId
GROUP BY e.id
HAVING count(m.managerId) >= 5;
