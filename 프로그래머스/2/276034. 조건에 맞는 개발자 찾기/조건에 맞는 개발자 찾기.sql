SELECT DISTINCT(D.ID), D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
JOIN SKILLCODES S ON D.SKILL_CODE & S.CODE > 0
WHERE S.NAME IN ('Python', 'C#')
ORDER BY D.ID ASC;