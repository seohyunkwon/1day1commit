select car_id, a.car_type , daily_Fee*30*(1-(p.discount_Rate/100)) fee from
(
select * from CAR_RENTAL_COMPANY_CAR where car_id not in (
select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where
(start_Date <= to_Date('2022-11-30', 'YYYY-MM-DD') and end_Date >= to_Date('2022-11-1', 'YYYY-MM-DD'))
)
and (car_type = 'SUV' or car_type='세단')
) a, 
CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
where a.car_type=p.car_type and p.duration_type='30일 이상'
and daily_Fee*30*(1-(p.discount_Rate/100)) between 500000 and 1999999
order by fee desc, a.car_type, car_id desc