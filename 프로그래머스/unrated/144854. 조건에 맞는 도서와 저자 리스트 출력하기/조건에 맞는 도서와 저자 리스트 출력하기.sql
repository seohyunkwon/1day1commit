-- 코드를 입력하세요
SELECT book_id, author_name, to_Char(published_date, 'yyyy-mm-dd') published_Date from book b, author a where b.author_id = a.author_id and b.category='경제' order by published_Date