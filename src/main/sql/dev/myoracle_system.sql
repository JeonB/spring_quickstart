select * from all_users; 	-- ��� ���� ���� ��ȸ

create user jeonb identified by 1234;	-- ���� ����

grant RESOURCE, CONNECT, DBA to jeonb; 		-- ���� �ο�

commit;			-- ������� ����
