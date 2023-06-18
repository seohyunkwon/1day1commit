-- 코드를 입력하세요
select flavor from (SELECT sum(total_order), flavor from ((select * from first_Half) union (select * from july)) group by(flavor) order by sum(total_order) desc) where rownum<=3;