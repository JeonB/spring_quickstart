select * from all_users; 	-- 모든 계정 정보 조회

create user jeonb identified by 1234;	-- 계정 생성

grant RESOURCE, CONNECT, DBA to jeonb; 		-- 권한 부여

commit;			-- 변경사항 저장
