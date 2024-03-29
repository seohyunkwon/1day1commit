SELECT A.PRODUCT_ID, PRODUCT_NAME, AMOUNT*PRICE TOTAL_SALES FROM (
    SELECT 
        PRODUCT_ID, SUM(AMOUNT) AMOUNT 
    FROM 
        FOOD_ORDER 
    WHERE 
        PRODUCE_DATE 
        BETWEEN TO_DATE('2022-05-01', 'YYYY-MM-DD') 
        AND TO_DATE('2022-05-31', 'YYYY-MM-DD') 
    GROUP BY PRODUCT_ID
    ) A, FOOD_PRODUCT P 
WHERE 
    A.PRODUCT_ID=P.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID