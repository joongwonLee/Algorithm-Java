-- 코드를 입력하세요
SELECT ri.REST_Id, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, ROUND(AVG(rr.REVIEW_SCORE), 2) SCORE
FROM REST_INFO ri JOIN REST_REVIEW rr ON ri.REST_ID = rr.REST_ID
WHERE SUBSTR(ri.ADDRESS, 1, 2) = '서울'
GROUP BY ri.REST_ID
ORDER BY AVG(rr.REVIEW_SCORE) DESC, ri.FAVORITES DESC