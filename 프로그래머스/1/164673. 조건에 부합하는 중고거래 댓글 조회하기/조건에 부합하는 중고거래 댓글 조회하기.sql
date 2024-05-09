-- 코드를 입력하세요
SELECT ugb.title TITLE, ugb.board_id BOARD_ID, ugr.reply_id REPLY_ID, ugr.writer_id WRITER_ID, ugr.contents CONTENTS, SUBSTR(ugr.created_date, 1, 10) CREATED_DATE
FROM USED_GOODS_BOARD ugb INNER JOIN USED_GOODS_REPLY ugr ON ugb.board_id = ugr.board_id
WHERE ugb.created_date LIKE '2022-10%'
ORDER BY ugr.created_date, ugb.title;
;