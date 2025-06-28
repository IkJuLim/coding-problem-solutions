# Write your MySQL query statement below
select uni.unique_id, e.name from Employees as e left outer join EmployeeUNI as uni on e.id = uni.id;