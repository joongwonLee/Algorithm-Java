-- 코드를 작성해주세요

SELECT ii.ITEM_ID ITEM_ID, ii.ITEM_NAME ITEM_NAME
FROM ITEM_INFO ii INNER JOIN ITEM_TREE it ON ii.ITEM_ID = it.ITEM_ID
WHERE it.PARENT_ITEM_ID IS NULL;