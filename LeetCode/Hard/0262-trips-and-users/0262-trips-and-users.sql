# Write your MySQL query statement below
SELECT T.request_at AS 'DAY', 
    ROUND(COUNT(IF(T.status != 'completed', TRUE, NULL))/COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips AS T
    LEFT JOIN Users AS UC ON UC.users_id = T.client_id
    LEFT JOIN Users AS UD ON UD.users_id = T.driver_id
WHERE T.request_at BETWEEN '2013-10-01' AND '2013-10-03'
    AND UC.banned = 'No'
    AND UD.banned = 'No'
GROUP BY T.request_at;