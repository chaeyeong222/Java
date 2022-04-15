--SYS 계정 접속 --
--최고 관리자 계정--

GRANT SELECT ON dept TO HR;

SELECT * 
FROM all_tables;

SELECT * 
FROM all_synonyms
WHERE synonym_name LIKE '%arirang%';

CREATE PUBLIC SYNONYM arirang FOR scott.dept;

SELECT *
FROM arirang;


-- 시노님 제거
DROP PUBLIC SYNONYM arirang;
-- 권한 제거

