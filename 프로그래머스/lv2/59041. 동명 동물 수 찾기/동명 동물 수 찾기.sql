SELECT * FROM 
(SELECT NAME, COUNT(NAME) COUNT FROM ANIMAL_INS GROUP BY NAME) 
WHERE COUNT>1 ORDER BY NAME