SELECT P.ID, P.NAME, P.HOST_ID
FROM PLACES P
WHERE P.HOST_ID IN (
               SELECT H.HOST_ID 
               FROM PLACES H
               GROUP BY H.HOST_ID
               HAVING COUNT(H.HOST_ID) > 1)
ORDER BY P.ID;