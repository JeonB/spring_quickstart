-- 0322�� �������� Ŀ�̼��� (NULL)�� �������� 0���� ġȯ�Ͽ� ��ȸ
    SELECT EMPNO,ENAME,NVL(COMM,0) FROM EMP;

-- || (CONCATENATION : ���տ�����)  : ���ڿ� ���ڸ� �����ϴ� ������
-- SMITH�� ������ CLERK �Դϴ�.
    SELECT ENAME || '�� ������ ' ||JOB||'�Դϴ�' AS ENAME FROM EMP WHERE ENAME='SMITH';

-- EMP ���̺��� �μ���ȣ 30�̰�, 1981�� ��ݱ� ������ �Ի��� ������� ��ȸ
SELECT * FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMP WHERE DEPTNO=30 AND TO_CHAR(HIREDATE,'YYMMDD') < '810701';

-- �� �÷����� ���� ������ �˻� : IN ������ 
-- ���� : SELECT [�÷�����Ʈ] FROM [���̺��]
--          WHERE �÷��� IN (������1, ������2, ������3...);

-- EMP ������� ������� SMITH �̰ų� WARD �̰ų� MILLER�� ������� ��ȸ
SELECT * FROM EMP WHERE ENAME IN ('SMITH','WARD','MILLER');

-- EMP ���̺��� Ŀ�̼��� 300 �̰ų� 500 �̰ų� 1400�� �޴� ������� ��ȸ
SELECT * FROM EMP WHERE COMM IN (300,500,1400);

-- NOT IN 
-- EMP ���̺��� Ŀ�̼��� 300 �̰ų� 500 �̰ų� 1400�� �޴� ������� �����ϰ� ��ȸ
-- 0323 ���� Ŀ�̼��� NULL�� ����� ����Ʈ 50���� ��ȯ�� ����
SELECT EMPNO,ENAME,JOB,SAL,NVL(COMM,50) AS COMM FROM EMP WHERE NVL(COMM,50) NOT IN (300,500,1400);

-- ������ �˻� : LIKE �����ڿ� ���ϵ�ī��(%, _ )
-- ���� : SELECT [�÷�����Ʈ] FROM [���̺��]
--          WHERE �÷��� LIKE '�˻�����[���ϵ� ī�� ����]';
--  % : �ϳ��̻��� ���ڸ� ��ü,  _ : �ѹ��ڸ� ��ü

-- EMP ���̺��� ������� A�� �����ϴ� ��� ����� ��ȸ
SELECT * FROM EMP WHERE ENAME LIKE 'A%';

-- EMP ���̺��� ������� �ι�° �ڸ��� A�� ���� ��� ����� ��ȸ
  SELECT * FROM EMP WHERE ENAME LIKE '_A%';

-- EMP ���̺��� ����� A�� ���� ��� ����� ��ȸ
  SELECT * FROM EMP WHERE ENAME LIKE '%A%';

-- EMP ���̺��� ����� A�� ���� �ʴ� ��� ����� ��ȸ
  SELECT * FROM EMP WHERE ENAME NOT LIKE '%A%';

--1. DUAL ���̺�� �Լ� ����
-- DUAL ���̺� ���� Ȯ��
select * from dual;

-- 2. ���� �Լ�
-- ABS : ���밪 ���ϱ� 
-- ���� : SELECT ABS(�÷���), ABS(���ڵ�����).. FROM [���̺��];
SELECT 10, -10 , ABS(10), ABS(-10)  FROM DUAL;

-- FLOOR : �Ҽ��� ������
SELECT 123.456, FLOOR(123.456) FROM DUAL;

-- TRUNC(ATE) : �Ҽ��� Ư�� �ڸ��� ������
SELECT 123.456, TRUNC(123.456), TRUNC(123.456, 1),  TRUNC(123.456, 2) 
FROM DUAL;

-- MOD : ������ ������ %
-- ���� : MOD(����1, ����2)
SELECT MOD(27,5), MOD(10,2), MOD(7,2)  FROM DUAL;

-- EMP ���̺��� ����� Ȧ���� ����鸸 ��ȸ


-- EMP ���̺��� ����� ¦���� ����鸸 ��ȸ



-- 2. ���� �Լ�
-- LOWER/UPPER/INITCAP  : �ҹ���/�빮��/ù���ڸ� �빮��
SELECT LOWER('HELLO'), UPPER('hello'), INITCAP('HELLO')  FROM DUAL;

-- EMP ���̺� ������� 'smith' �ҹ��ڷ� ��ȸ : �Էµ� ������ ����
 -- �Էµ� ������ ����

 -- �÷� ������ ����

-- LENGTH/LENGTHB : ���ڿ� ����
SELECT LENGTH('ORACLE'), LENGTHB('ORACLE') FROM DUAL;
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') FROM DUAL; --�ѱ��� �ѱ��ڴ� 3����Ʈ

-- TRIM/LTRIM/RTRIM : �������
SELECT TRIM('      ORACLE        ') TRIM FROM DUAL;
SELECT LTRIM('         ORACLE') LTRIM FROM DUAL;
SELECT RTRIM('ORACLE            ') RTRIM FROM DUAL;

-- SUBSTR : ���ڿ� �Ϻ� ����
-- ���� : SUBSTR(���ڿ�, ����, ���⹮�ڼ�);
SELECT SUBSTR('ORACLE', 1, 3)  FROM DUAL;  -- ORA
SELECT SUBSTR('ORACLE', 3, 2)  FROM DUAL;  -- AC
SELECT SUBSTR('ORACLE', -2, 3)  FROM DUAL;  --LE

-- EMP ���̺��� �����ȣ, �����, �Ի���(�⵵), �μ���ȣ ��ȸ


-- EMP ���̺��� 30�� �μ��� ����鿡 ���� �����ȣ, �����, �Ի��, �μ���ȣ ��ȸ


-- EMP ���̺��� �����, �Ի�⵵, �Ի��, �Ի���  ��ȸ
      

-- 81�⵵ �Ի��� ��ü ��ȸ


-- 81�⵵�� ������ �Ի��� ��ü ��ȸ


-- INSTR : Ư�� ���ڿ� ã�� �Լ�
-- ���� : INSTR(��ü���ڿ�, ã������, ������ġ, �� ��° ��� �˻�)
SELECT INSTR('WELCOME TO ORACLE!!!', 'O',1) FROM DUAL ;  --5(ã�������� �ڸ���)
SELECT INSTR('WELCOME TO ORACLE!!!', 'O',1, 2) FROM DUAL ;  --10(�ι�° O �� �ڸ���)
SELECT INSTR('WELCOME TO ORACLE!!!', 'O',11, 1) FROM DUAL ;  --12(O �� �ڸ���)

-- LPAD/RPAD : Ư�� ���� ä���
-- ���� : LPAD/RPAD(���ڿ�, ��ü���ڿ�����, Ư������);
SELECT LPAD('ORACLE',20) LPAD FROM DUAL;  -- Ư������ ������ ����Ʈ�� ����
SELECT LPAD('ORACLE',20, '#') LPAD FROM DUAL;

SELECT RPAD('ORACLE',20) RPAD FROM DUAL;  -- Ư������ ������ ����Ʈ�� ����
SELECT RPAD('ORACLE',20, '#') RPAD FROM DUAL;

-- EMP ���̺��� ������� ��ü���̸� 30���� ���ϰ�, ������ ������ �������� ä���� ��ȸ


-- 3. ��¥ �Լ� : SQL ǥ���� ����('') ó��, ������ ����ó��
-- SYSDATE : �ý����� ��¥ ��ȯ�ϴ� �Լ�
SELECT SYSDATE, SYSDATE+1, SYSDATE + 10 FROM DUAL;

-- EMP ���̺��� SMITH ����� ���糯¥ ��������  �ٹ��ϼ��� ��ȸ
-- �ٹ��ϼ��� �Ҽ����� ����


-- EMP ���̺��� SMITH ����� ���糯¥ ��������  �ٹ��ϼ��� ��ȸ
-- �ٹ��ϼ��� �Ҽ����� 2�ڸ� ���


-- �ٹ� ���� �� : MONTHS_BETWEEN(���س�¥, �Ի���)
-- EMP ���̺� ����� �����ȣ, �����, �Ի���, �ٹ�����, �ٹ��ϼ�, �μ���ȣ ��ȸ
-- �ٹ�����, �ٹ��ϼ��� �Ҽ����� ����
          

-- EMP ���̺� ����� �����ȣ, �����, �Ի���, �ٹ�����, �ٹ��ϼ�, �μ���ȣ ��ȸ
-- �ٹ�����, �ٹ��ϼ��� �Ҽ����� ����
-- �ٹ������� 500���� �̻��� ����� ��ȸ


-- ���س�¥�� ������ ���ϱ� : ADD_MONTHS
-- ���� : ADD_MONTHS(���س�¥, ������)

-- ���ó�¥�� �Ի��� ����� 6���� �� ��¥ ��ȸ


-- EMP ������� �Ի��� ���� 600���� �� ��¥ ��ȸ
-- ���糯¥ 600�������� �ٹ�������, �ٹ��ϼ� ��ȸ
-- ��ȸ �׸� �����ȣ, �����, �Ի���, 600������(�Ի��ϱ���), �ٹ�����(���糯¥), �ٹ��ϼ�(���糯¥)

-- 5. ����ȯ �Լ� : ����Ŭ�� ������ Ÿ���� �ٸ� ������ Ÿ������ ��ȯ�� �ִ� �Լ�
-- ���� : TO_��ȯ�ϴ� Ÿ�� 
--         ��) TO_NUMBER, TO_CHAR, TO_DATE
-- TO_CHAR : ���ڳ� ��¥�� ���� ������ Ÿ������ ��ȯ
-- TO_NUMBER : ���ڸ� ���� ������ Ÿ������ ��ȯ
-- TO_DATE :  ���ڸ� ��¥ ������ Ÿ������ ��ȯ

-- 1) TO_CHAR : ��¥�� ���� ������ Ÿ������ ��ȯ
-- ���� : TO_CHAR("��¥������", "���ں�ȯ�� ����") - YY/MM/DD(��¥�⺻����) ->YYYY-MM-DD ��..
-- ��ȯ ���� : YYYY(�⵵ 4�ڸ�), YY(�⵵ 2�ڸ�), MM(�� 2�ڸ�), MON(�� ���ĺ�)
--                , DAY(�� ����ǥ��), DY(���� ���), DD(���� ����ǥ��)

-- ���� ��¥ ��ȸ
SELECT SYSDATE FROM DUAL;

-- EMP ���̺��� �����ȣ, �����, �Ի���, �μ���ȣ�� ��ȸ
-- �Ի糯¥ ������ 'YYYY-MM-DD' �������� ��ȸ
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD'),DEPTNO FROM EMP;

-- TO_CHAR : �ð����� �߰�
-- ���� : TO_CHAR(��¥������, '��¥��ȯ���� �ð���ȯ����')
-- �ð� ��ȯ ���� : AM/PM(����/����), HH(�ð�), MI(��), SS(��), HH24(24�ð� ����)


-- 2) TO_CHAR : ���ڵ����͸� ���ڵ����ͷ� ��ȯ - 3�ڸ��� �޸�(,)�� ����..
-- ���� : TO_CHAR(���ڵ�����, ��ȯ�ϴ� ����)
-- ��ȯ ���� : 0(���ڸ��� 0���� ä��), 9(�ڸ����� ���� ������ ���� ä��),
--                L(�� ������ ��ȭ��ȣ ǥ��), �޸� : 3�ڸ��� ��� ǥ��

-- EMP ���̺��� �޿��� 3�ڸ��� �޸��� �����Ͽ� ��ȸ
SELECT TO_CHAR(SAL,'L9,999') FROM EMP;

-- EMP ���̺��� �����ȣ, �����, �޿�, Ŀ�̼�, �ѱ޿�(�޿�+Ŀ�̼�), �μ���ȣ ��ȸ
-- 0324 ��¥ ���� Ŀ�̼��� ��ϵ��� ���� ����� �⺻�� 1000���� �Է�
-- �޿�, Ŀ�̼��� 3�ڸ� ������ �����Ͽ� ���
-- �Ի��� �÷� ������ 'YYYY"��" MM"��"  DD"��"'  �������� ���
SELECT EMPNO,ENAME,SAL,TO_CHAR(NVL(COMM,1000),'$9,999') COMM,
TO_CHAR((SAL+NVL(COMM,1000)),'$9,999') TOTAL_SAL, 
(TO_CHAR(HIREDATE,'YYYY')||'��'||TO_CHAR(HIREDATE,'MM')||'��'||TO_CHAR(HIREDATE,'DD')||'��') �Ի��� ,DEPTNO
FROM EMP;


-- TO_DATE : ����/���� �����͸� ��¥ ������ ��ȯ
-- ���� : TO_DATE(����/��¥������ , 'YY/MM/DD')

-- '2023/03/24' ���ڵ����͸� ��¥ ������ ��ȯ
SELECT TO_DATE('2023/03/24','YYYY-MM-DD') FROM DUAL;

-- '2023/03/24' ���ڵ����͸� 'YYYY-MM-DD' ������ ��¥ ������ ��ȯ


-- 20230324  ���ڵ����͸� ��¥ �����ͷ� ��ȯ


-- TO_NUMBER : ���ڵ����͸� ���ڵ����ͷ� ��ȯ
-- ���� : TO_NUMBER('���ڵ�����', ��ȯ ����)

-- '200'-'100' ���ڵ����� 200�� ���ڵ����ͷ� ��ȯ
SELECT TO_NUMBER('200'-'100') FROM DUAL;
SELECT '200'-'100', TO_NUMBER('200', '999') - TO_NUMBER('100','999') FROM DUAL;
-- 6) DECODE �Լ�
-- ���� : DECODE (ǥ����, ����1, ���1, 
--                                  ����2, ���2,
--                        �⺻���)

-- EMP ���̺��� �����ȣ�� DECODE �Լ��� �����Ͽ� �μ����� ���
-- 10(ACCOUNTING), 20(RESEARCH), 30(SALES), 40(OPERATIONS)
-- �����ȣ, �����, �Ի���, �μ���ȣ, �μ��� ��ȸ
  SELECT EMPNO, 
           ENAME,
           HIREDATE,
           DEPTNO,
           DECODE(DEPTNO, 10, 'ACCOUNTING',
                                    20, 'RESEARCH',
                                    30, 'SALES',
                                    40, 'OPERATIONS') AS DNAME
FROM EMP;          

-- 1) �׷��Լ� : SUM, AVG, MIN, MAX, COUNT...
-- ����) �׷��Լ�(�÷���)

-- EMP ���̺� ������� �޿��հ踦 ��ȸ
-- 3�ڸ� ����, ��ȭ��ȣ �����ϱ�
SELECT TO_CHAR(SUM(SAL),'$999,999') �ѱ޿� FROM EMP;

-- EMP ���̺��� ��ü ����� ��ȸ
SELECT COUNT(ENAME) FROM EMP;

-- 30�� �μ��� ������ ��ȸ
SELECT COUNT(ENAME) FROM EMP WHERE DEPTNO=30;

-- ������ MANAGER�� ������ ��ȸ


-- EMP ���̺��� ������� ���Ե� �μ� ���� ��ȸ(�ߺ�����)
SELECT COUNT( DISTINCT DEPTNO) FROM EMP;

-- JOB�� ���� ��ȸ(�ߺ�����)
SELECT COUNT( DISTINCT JOB) FROM EMP;

-- Ŀ�̼��� �޴� ������� ��ȸ, ��������� Ŀ�̼��� ��Ͼȵ� ����� 0���� ġȯ
SELECT COUNT(COMM) FROM EMP WHERE NVL(COMM,0) NOT IN(0);
SELECT COMM FROM EMP;
-- ��� ����� �ѱ޿��հ�, �޿���� ��ȸ
-- �Ҽ���2�ڸ� ���, 3�ڸ� ����, ��ȭ��ȣ ǥ��


-- �Ŵ����� ������ �ִ� ����� ��ȸ


-- �Ŵ����� ���� ����� ��ȸ : NULL �����ʹ� COUNT �Լ��� üũ �Ұ�


-- �ѱ޿��հ�, ��ձ޿�, �ְ�޿�, �����޿� ��ȸ


-- �Ի����� ���� ������ ���, ���� �ֱ� �Ի��� ���


-- 2) GROUP BY : �κ��հ踦 ���Ҷ� ���
-- ���� : SELECT [�÷�����Ʈ,...], [�κ����� ���� �÷���]  FROM ���̺��
--         GROUP BY [�κ����� ���� �÷���]
--         WHERE [���� �˻�]

-- �μ��� ����� ��ȸ
SELECT DEPTNO,COUNT(ENAME) FROM EMP GROUP BY DEPTNO;

-- �����ȣ�� ����� ��ȸ
SELECT EMPNO,COUNT(ENAME) FROM EMP GROUP BY EMPNO;

-- �μ��� �ְ�޿�, �����޿��� ��ȸ
SELECT DEPTNO, MAX(SAL), MIN(SAL) FROM EMP GROUP BY DEPTNO;

-- ������ �ְ�޿�, �����޿��� ��ȸ
SELECT MAX(SAL), MIN(SAL) FROM EMP GROUP BY JOB;

-- �Ի�⵵�� ����� ��ȸ


-- �Ի�⵵, �Ի���� ����� ��ȸ



-- 3) HAVING �� : GROUP BY �� ����� ���� ������
-- EMP ���̺��� �μ��� ��ձ޿� ��ȸ
-- ��ձ޿��� 2000 �̻��� �μ��� ��ȸ
SELECT DEPTNO, FLOOR(AVG(SAL)) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) >= 2000;

-- ������ �ְ�޿�, �����޿��� ��ȸ
-- �ְ�޿��� 2500 �̻��� ����� ��ȸ


-- �Ի�⵵�� �ְ�޿�, �����޿��� ��ȸ
-- �ְ�޿��� 3000 ����, �����޿��� 800 �̻��� ����� ��ȸ


-- 4) ROLLUP/CUBE �Լ� : �׷����� ����� �߰������� ��� ����
-- ���� : GROUP BY [�׷����� �÷�] ROLLUP/CULE([�׷����� �÷�])

-- �Ի�⵵�� ����� ��ȸ : ROLLUP �Լ� ���
SELECT SUBSTR(HIREDATE,1,2), COUNT(*) FROM EMP
GROUP BY ROLLUP(SUBSTR(HIREDATE,1,2))
ORDER BY SUBSTR(HIREDATE,1,2);

-- �μ��� �ѱ޿��� ���ϰ� ROLLUP �Լ��� ����
-- �ݾ��� 3�ڸ� ����, ��ȭ��ȣ ǥ��
SELECT NVL(TO_CHAR(DEPTNO) ,'���հ�') �μ���,
          TO_CHAR(SUM(SAL),'L999,999') �޿��հ� 
FROM EMP
GROUP BY ROLLUP(DEPTNO)
ORDER BY DEPTNO;

-- �μ��� ������ �ѱ޿� ��ȸ : ROLLUP �Լ� ���
SELECT NVL(TO_CHAR(DEPTNO),'�ѱ޿�') �μ���,
TO_CHAR(SUM(SAL),'$999,999') �޿��հ�, NVL(JOB, '�հ�') ����
FROM EMP
GROUP BY ROLLUP(DEPTNO,JOB);

-- �Ի�⵵�� ����� ��ȸ : CUBE �Լ� ���


-- �μ��� ������ �ѱ޿� ��ȸ : CUBE �Լ� ���
SELECT NVL(SUBSTR(HIREDATE,1,2), '���ο���') �Ի�⵵, 
            COUNT(*) �����
FROM EMP
GROUP BY CUBE(SUBSTR(HIREDATE,1,2))
ORDER BY SUBSTR(HIREDATE,1,2);
-- 10�� �μ��� ������� �����ȣ, �����, �Ի���, �޿�, �μ���ȣ�� ��ȸ


-- 30�� �μ��� ������� �����ȣ, �����, �Ի���, �޿�, �μ���ȣ�� ��ȸ


-- 10�� �μ��� ����� 30�� �μ��� ��� ��ȸ�����  UNION�� ����Ͽ� ���

-- 10�� �μ��� ����� 30�� �μ��� ��� ��ȸ�����  UNION ALL�� ����Ͽ� ���