SELECT TITLE, B.BOARD_ID, REPLY_ID, R.WRITER_ID, R.CONTENTS, TO_CHAR(R.CREATED_DATE,'YYYY-MM-DD') CREATED_DATE FROM USED_GOODS_BOARD B, USED_GOODS_REPLY R 
 WHERE TO_CHAR(B.CREATED_DATE, 'YYYY/MM')='2022/10' 
AND B.BOARD_ID=R.BOARD_ID 
ORDER BY R.CREATED_DATE, B.TITLE