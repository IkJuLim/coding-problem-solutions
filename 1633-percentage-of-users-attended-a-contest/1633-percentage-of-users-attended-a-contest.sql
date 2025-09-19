# Write your MySQL query statement below
SELECT r.contest_id , ROUND( COUNT(u.user_id) / (SELECT COUNT(*) FROM Users) * 100, 2 ) as percentage
FROM Users as u
RIGHT JOIN Register as r
ON r.user_id = u.user_id
GROUP BY r.contest_id
ORDER BY COUNT(u.user_id) DESC, r.contest_id
;