SELECT E.ID, 
(SELECT COUNT(PARENT_ID) FROM ECOLI_DATA
 WHERE E.ID = PARENT_ID
) AS CHILD_COUNT
FROM ECOLI_DATA E;