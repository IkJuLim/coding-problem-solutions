# Write your MySQL query statement below
SELECT p.project_id, ROUND(SUM(e.experience_years) / COUNT(e.experience_years), 2) as average_years
FROM Project as p
JOIN Employee as e
ON p.employee_id = e.employee_id
GROUP BY p.project_id
ORDER BY p.project_id
;