select to_char(sales_date, 'yyyy-MM-dd') sales_Date,product_id,  user_id, sales_amount from 
(select user_id , product_id, sales_Amount, sales_Date from online_Sale
union all
select null as user_id , product_id, sales_Amount, sales_Date from offline_sale) where to_char(sales_Date, 'yyyy-MM') = '2022-03' order by sales_date, product_id, user_id