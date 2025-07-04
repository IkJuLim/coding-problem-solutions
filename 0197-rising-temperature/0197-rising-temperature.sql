# Write your MySQL query statement below
SELECT today.id
FROM Weather AS today
    INNER JOIN Weather AS yesterday 
        ON DATE_ADD(yesterday.recordDate, Interval 1 day) = today.recordDate
WHERE today.temperature > yesterday.temperature;