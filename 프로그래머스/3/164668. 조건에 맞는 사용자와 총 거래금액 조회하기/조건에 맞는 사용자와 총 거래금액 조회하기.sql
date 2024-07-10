-- 코드를 입력하세요
SELECT ugu.user_id USER_ID, ugu.nickname NICKNAME, SUM(ugb.price) TOTAL_SALES
FROM USED_GOODS_BOARD ugb  JOIN USED_GOODS_USER ugu ON ugb.writer_id = ugu.user_id
WHERE ugb.status = 'DONE'
GROUP BY ugu.user_id
HAVING SUM(ugb.price) >= 700000
ORDER BY SUM(ugb.price)