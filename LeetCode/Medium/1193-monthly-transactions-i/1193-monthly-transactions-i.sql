# Write your MySQL query statement below
SELECT DATE_FORMAT(t.trans_date, '%Y-%m') as month, 
    t.country, 
    count(t.state) as trans_count,
    sum(t.state = 'approved') as approved_count, 
    sum(t.amount)as trans_total_amount,
    sum((t.state = 'approved') * t.amount) as approved_total_amount
FROM Transactions as t
GROUP BY DATE_FORMAT(t.trans_date, '%Y-%m'), t.country