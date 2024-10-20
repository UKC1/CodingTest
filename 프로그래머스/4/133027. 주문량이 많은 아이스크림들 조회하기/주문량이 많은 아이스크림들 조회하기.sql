SELECT FLAVOR
FROM (
    -- 상반기 주문량
    SELECT FLAVOR, TOTAL_ORDER
    FROM FIRST_HALF
    UNION ALL
    -- 7월 주문량
    SELECT FLAVOR, TOTAL_ORDER
    FROM JULY
) AS combined_orders
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;
