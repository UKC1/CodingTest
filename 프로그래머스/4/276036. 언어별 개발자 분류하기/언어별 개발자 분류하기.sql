WITH category AS(
    SELECT category, SUM(code) code
    FROM skillcodes
    GROUP BY category
)

SELECT *
FROM(
    SELECT
        CASE
            WHEN ((SELECT code FROM category WHERE category = 'Front End') & skill_code != 0)
            AND ((SELECT code FROM skillcodes WHERE name = 'Python') & skill_code != 0) THEN 'A'
            WHEN ((SELECT code FROM skillcodes WHERE name = 'C#') & skill_code != 0) THEN 'B'
            WHEN ((SELECT code FROM category WHERE category = 'Front End') & skill_code != 0) THEN 'C'
            ELSE NULL
        END grade,
        id,
        email
    FROM developers
) a
WHERE grade IS NOT NULL
ORDER BY 1, 2