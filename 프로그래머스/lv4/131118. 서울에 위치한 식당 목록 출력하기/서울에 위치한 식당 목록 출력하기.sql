select r.rest_id, rest_name, food_type, favorites, address,  score
from rest_info r, 
(select rest_id, round(sum(review_score)/count(*),2) score from rest_review group by rest_id ) a where r.rest_id=a.rest_id and address like '서울%' order by score desc, favorites desc