# Write your MySQL query statement below
select s.student_id, s.student_name, sbj.subject_name, count(e.subject_name) as attended_exams
from Students as s 
    cross join Subjects as sbj 
        left outer join Examinations as e 
            on s.student_id = e.student_id 
                and sbj.subject_name = e.subject_name
group by s.student_id, sbj.subject_name
order by s.student_id, sbj.subject_name
