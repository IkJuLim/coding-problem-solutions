# Write your MySQL query statement below
SELECT query_name, round(sum(q.rating / q.position) / count(q.result), 2) as quality, round(1 / count(q.query_name) * 100, 2) as poor_query_percentage
FROM Queries as q
GROUP BY q.query_name
;