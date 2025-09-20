# Write your MySQL query statement below
select start_Activity.machine_id, round((sum(end_Activity.timestamp) - sum(start_Activity.timestamp)) / count(*), 3) as processing_time
from Activity as start_Activity
inner join Activity as end_Activity
on start_Activity.machine_id = end_Activity.machine_id 
and start_Activity.process_id = end_Activity.process_id 
and start_Activity.activity_type = 'start' 
and end_Activity.activity_type = 'end'
group by start_Activity.machine_id

-- # Write your MySQL query statement below
-- select start_Activity.machine_id, end_Activity.timestamp - start_Activity.timestamp as processing_time
-- from Activity as start_Activity
-- inner join Activity as end_Activity
-- on start_Activity.machine_id = end_Activity.process_id and start_Activity.process_id = end_Activity.process_id and
-- start_Activity.activity_type = 'start' and end_Activity.activity_type = 'end'
-- group by start_Activity.machine_id