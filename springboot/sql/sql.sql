select q.id,student_id, username ,title,content,send_time
from question q, student s
where q.student_id = s.id