-- 0322일 기준으로 커미션이 (NULL)인 직원들은 0으로 치환하여 조회
    SELECT EMPNO,ENAME,NVL(COMM,0) FROM EMP;

-- || (CONCATENATION : 접합연산자)  : 문자와 문자를 결합하는 연산자
-- SMITH의 직무는 CLERK 입니다.
    SELECT ENAME || '의 직무는 ' ||JOB||'입니다' AS ENAME FROM EMP WHERE ENAME='SMITH';

-- EMP 테이블의 부서번호 30이고, 1981년 상반기 이전에 입사한 사원들을 조회
SELECT * FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMP WHERE DEPTNO=30 AND TO_CHAR(HIREDATE,'YYMMDD') < '810701';

-- 한 컬럼에서 여러 데이터 검색 : IN 연산자 
-- 형식 : SELECT [컬럼리스트] FROM [테이블명]
--          WHERE 컬럼명 IN (데이터1, 데이터2, 데이터3...);

-- EMP 사원들중 사원명이 SMITH 이거나 WARD 이거나 MILLER인 사원들을 조회
SELECT * FROM EMP WHERE ENAME IN ('SMITH','WARD','MILLER');

-- EMP 테이블에서 커미션이 300 이거나 500 이거나 1400을 받는 사원들을 조회
SELECT * FROM EMP WHERE COMM IN (300,500,1400);

-- NOT IN 
-- EMP 테이블에서 커미션이 300 이거나 500 이거나 1400을 받는 사원들을 제외하고 조회
-- 0323 기준 커미션이 NULL인 사람은 디폴트 50으로 변환후 실행
SELECT EMPNO,ENAME,JOB,SAL,NVL(COMM,50) AS COMM FROM EMP WHERE NVL(COMM,50) NOT IN (300,500,1400);

-- 데이터 검색 : LIKE 연산자와 와일드카드(%, _ )
-- 형식 : SELECT [컬럼리스트] FROM [테이블명]
--          WHERE 컬럼명 LIKE '검색문자[와일드 카드 문자]';
--  % : 하나이상의 문자를 대체,  _ : 한문자를 대체

-- EMP 테이블에서 사원명이 A로 시작하는 모든 사원을 조회
SELECT * FROM EMP WHERE ENAME LIKE 'A%';

-- EMP 테이블에서 사원명이 두번째 자리에 A가 들어가는 모든 사원을 조회
  SELECT * FROM EMP WHERE ENAME LIKE '_A%';

-- EMP 테이블에서 사원명에 A가 들어가는 모든 사원을 조회
  SELECT * FROM EMP WHERE ENAME LIKE '%A%';

-- EMP 테이블에서 사원명에 A가 들어가지 않는 모든 사원을 조회
  SELECT * FROM EMP WHERE ENAME NOT LIKE '%A%';

--1. DUAL 테이블과 함수 실행
-- DUAL 테이블 구조 확인
select * from dual;

-- 2. 숫자 함수
-- ABS : 절대값 구하기 
-- 형식 : SELECT ABS(컬럼명), ABS(숫자데이터).. FROM [테이블명];
SELECT 10, -10 , ABS(10), ABS(-10)  FROM DUAL;

-- FLOOR : 소수점 버리기
SELECT 123.456, FLOOR(123.456) FROM DUAL;

-- TRUNC(ATE) : 소수점 특정 자릿수 버리기
SELECT 123.456, TRUNC(123.456), TRUNC(123.456, 1),  TRUNC(123.456, 2) 
FROM DUAL;

-- MOD : 나머지 연산자 %
-- 형식 : MOD(숫자1, 숫자2)
SELECT MOD(27,5), MOD(10,2), MOD(7,2)  FROM DUAL;

-- EMP 테이블에서 사번이 홀수인 사원들만 조회


-- EMP 테이블에서 사번이 짝수인 사원들만 조회



-- 2. 문자 함수
-- LOWER/UPPER/INITCAP  : 소문자/대문자/첫글자만 대문자
SELECT LOWER('HELLO'), UPPER('hello'), INITCAP('HELLO')  FROM DUAL;

-- EMP 테이블에 사원명을 'smith' 소문자로 조회 : 입력된 데이터 기준
 -- 입력된 데이터 기준

 -- 컬럼 데이터 기준

-- LENGTH/LENGTHB : 문자열 길이
SELECT LENGTH('ORACLE'), LENGTHB('ORACLE') FROM DUAL;
SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL; --한글은 한글자당 3바이트

-- TRIM/LTRIM/RTRIM : 공백삭제
SELECT TRIM('      ORACLE        ') TRIM FROM DUAL;
SELECT LTRIM('         ORACLE') LTRIM FROM DUAL;
SELECT RTRIM('ORACLE            ') RTRIM FROM DUAL;

-- SUBSTR : 문자열 일부 추출
-- 형식 : SUBSTR(문자열, 시작, 추출문자수);
SELECT SUBSTR('ORACLE', 1, 3)  FROM DUAL;  -- ORA
SELECT SUBSTR('ORACLE', 3, 2)  FROM DUAL;  -- AC
SELECT SUBSTR('ORACLE', -2, 3)  FROM DUAL;  --LE

-- EMP 테이블에서 사원번호, 사원명, 입사일(년도), 부서번호 조회


-- EMP 테이블에서 30번 부서의 사원들에 대한 사원번호, 사원명, 입사월, 부서번호 조회


-- EMP 테이블의 사원명, 입사년도, 입사월, 입사일  조회
      

-- 81년도 입사자 전체 조회


-- 81년도를 제외한 입사자 전체 조회


-- INSTR : 특정 문자열 찾는 함수
-- 형식 : INSTR(전체문자열, 찾을문자, 시작위치, 몇 번째 대상 검색)
SELECT INSTR('WELCOME TO ORACLE!!!', 'O',1) FROM DUAL ;  --5(찾을문자의 자릿수)
SELECT INSTR('WELCOME TO ORACLE!!!', 'O',1, 2) FROM DUAL ;  --10(두번째 O 의 자릿수)
SELECT INSTR('WELCOME TO ORACLE!!!', 'O',11, 1) FROM DUAL ;  --12(O 의 자릿수)

-- LPAD/RPAD : 특정 문자 채우기
-- 형식 : LPAD/RPAD(문자열, 전체문자열길이, 특정문자);
SELECT LPAD('ORACLE',20) LPAD FROM DUAL;  -- 특정문자 생략시 디폴트는 공백
SELECT LPAD('ORACLE',20, '#') LPAD FROM DUAL;

SELECT RPAD('ORACLE',20) RPAD FROM DUAL;  -- 특정문자 생략시 디폴트는 공백
SELECT RPAD('ORACLE',20, '#') RPAD FROM DUAL;

-- EMP 테이블의 사원명의 전체길이를 30으로 정하고, 오른쪽 여백을 공백으로 채워서 조회


-- 3. 날짜 함수 : SQL 표현은 문자('') 처럼, 실행은 숫자처럼
-- SYSDATE : 시스템의 날짜 반환하는 함수
SELECT SYSDATE, SYSDATE+1, SYSDATE + 10 FROM DUAL;

-- EMP 테이블의 SMITH 사원의 현재날짜 기준으로  근무일수를 조회
-- 근무일수의 소수점은 절삭


-- EMP 테이블의 SMITH 사원의 현재날짜 기준으로  근무일수를 조회
-- 근무일수의 소수점은 2자리 출력


-- 근무 개월 수 : MONTHS_BETWEEN(기준날짜, 입사일)
-- EMP 테이블 사원의 사원번호, 사원명, 입사일, 근무월수, 근무일수, 부서번호 조회
-- 근무월수, 근무일수의 소수점은 절삭
          

-- EMP 테이블 사원의 사원번호, 사원명, 입사일, 근무월수, 근무일수, 부서번호 조회
-- 근무월수, 근무일수의 소수점은 절삭
-- 근무월수가 500개월 이상인 사원만 조회


-- 기준날짜에 개월수 더하기 : ADD_MONTHS
-- 형식 : ADD_MONTHS(기준날짜, 개월수)

-- 오늘날짜로 입사한 사원의 6개월 후 날짜 조회


-- EMP 사원들의 입사일 기준 600개월 후 날짜 조회
-- 현재날짜 600개월후의 근무개월수, 근무일수 조회
-- 조회 항목 사원번호, 사원명, 입사일, 600개월후(입사일기준), 근무월수(현재날짜), 근무일수(현재날짜)

-- 5. 형변환 함수 : 오라클의 데이터 타입을 다른 데이터 타입으로 변환해 주는 함수
-- 형식 : TO_변환하는 타입 
--         예) TO_NUMBER, TO_CHAR, TO_DATE
-- TO_CHAR : 숫자나 날짜를 문자 데이터 타입으로 변환
-- TO_NUMBER : 문자를 숫자 데이터 타입으로 변환
-- TO_DATE :  문자를 날짜 데이터 타입으로 변환

-- 1) TO_CHAR : 날짜를 문자 데이터 타입으로 변환
-- 형식 : TO_CHAR("날짜데이터", "문자변환시 포맷") - YY/MM/DD(날짜기본포맷) ->YYYY-MM-DD 등..
-- 변환 포맷 : YYYY(년도 4자리), YY(년도 2자리), MM(월 2자리), MON(월 알파벳)
--                , DAY(일 요일표현), DY(일자 약어), DD(일자 숫자표현)

-- 현재 날짜 조회
SELECT SYSDATE FROM DUAL;

-- EMP 테이블의 사원번호, 사원명, 입사일, 부서번호를 조회
-- 입사날짜 포맷을 'YYYY-MM-DD' 형식으로 조회
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD'),DEPTNO FROM EMP;

-- TO_CHAR : 시간포맷 추가
-- 형식 : TO_CHAR(날짜데이터, '날짜변환포맷 시간변환포맷')
-- 시간 변환 포맷 : AM/PM(오전/오후), HH(시간), MI(분), SS(초), HH24(24시간 기준)


-- 2) TO_CHAR : 숫자데이터를 문자데이터로 변환 - 3자리씩 콤마(,)로 구분..
-- 형식 : TO_CHAR(숫자데이터, 변환하는 포맷)
-- 변환 포맷 : 0(빈자리를 0으로 채움), 9(자릿수가 맞지 않으면 공백 채움),
--                L(각 나라의 통화기호 표시), 콤마 : 3자리씩 끊어서 표현

-- EMP 테이블의 급여를 3자리씩 콤마로 구분하여 조회
SELECT TO_CHAR(SAL,'L9,999') FROM EMP;

-- EMP 테이블의 사원번호, 사원명, 급여, 커미션, 총급여(급여+커미션), 부서번호 조회
-- 0324 날짜 기준 커미션이 등록되지 않은 사원은 기본값 1000으로 입력
-- 급여, 커미션은 3자리 단위로 구분하여 출력
-- 입사일 컬럼 형식은 'YYYY"년" MM"월"  DD"일"'  형식으로 출력
SELECT EMPNO,ENAME,SAL,TO_CHAR(NVL(COMM,1000),'$9,999') COMM,
TO_CHAR((SAL+NVL(COMM,1000)),'$9,999') TOTAL_SAL, 
(TO_CHAR(HIREDATE,'YYYY')||'년'||TO_CHAR(HIREDATE,'MM')||'월'||TO_CHAR(HIREDATE,'DD')||'일') 입사일 ,DEPTNO
FROM EMP;


-- TO_DATE : 숫자/문자 데이터를 날짜 데이터 변환
-- 형식 : TO_DATE(숫자/날짜데이터 , 'YY/MM/DD')

-- '2023/03/24' 문자데이터를 날짜 데이터 변환
SELECT TO_DATE('2023/03/24','YYYY-MM-DD') FROM DUAL;

-- '2023/03/24' 문자데이터를 'YYYY-MM-DD' 형식의 날짜 데이터 변환


-- 20230324  숫자데이터를 날짜 데이터로 변환


-- TO_NUMBER : 문자데이터를 숫자데이터로 변환
-- 형식 : TO_NUMBER('문자데이터', 변환 포맷)

-- '200'-'100' 문자데이터 200을 숫자데이터로 변환
SELECT TO_NUMBER('200'-'100') FROM DUAL;
SELECT '200'-'100', TO_NUMBER('200', '999') - TO_NUMBER('100','999') FROM DUAL;
-- 6) DECODE 함수
-- 형식 : DECODE (표현식, 조건1, 결과1, 
--                                  조건2, 결과2,
--                        기본결과)

-- EMP 테이블의 사원번호에 DECODE 함수를 적용하여 부서명을 출력
-- 10(ACCOUNTING), 20(RESEARCH), 30(SALES), 40(OPERATIONS)
-- 사원번호, 사원명, 입사일, 부서번호, 부서명 조회
  SELECT EMPNO, 
           ENAME,
           HIREDATE,
           DEPTNO,
           DECODE(DEPTNO, 10, 'ACCOUNTING',
                                    20, 'RESEARCH',
                                    30, 'SALES',
                                    40, 'OPERATIONS') AS DNAME
FROM EMP;          

-- 1) 그룹함수 : SUM, AVG, MIN, MAX, COUNT...
-- 형식) 그룹함수(컬럼명)

-- EMP 테이블 사원들의 급여합계를 조회
-- 3자리 구분, 통화기호 포함하기
SELECT TO_CHAR(SUM(SAL),'$999,999') 총급여 FROM EMP;

-- EMP 테이블의 전체 사원수 조회
SELECT COUNT(ENAME) FROM EMP;

-- 30번 부서의 직원수 조회
SELECT COUNT(ENAME) FROM EMP WHERE DEPTNO=30;

-- 직무가 MANAGER인 직원수 조회


-- EMP 테이블의 사원들이 포함된 부서 갯수 조회(중복제거)
SELECT COUNT( DISTINCT DEPTNO) FROM EMP;

-- JOB의 갯수 조회(중복제거)
SELECT COUNT( DISTINCT JOB) FROM EMP;

-- 커미션을 받는 사원수를 조회, 현재시점에 커미션이 등록안된 사원은 0으로 치환
SELECT COUNT(COMM) FROM EMP WHERE NVL(COMM,0) NOT IN(0);
SELECT COMM FROM EMP;
-- 모든 사원의 총급여합계, 급여평균 조회
-- 소수점2자리 출력, 3자리 구분, 통화기호 표시


-- 매니저를 가지고 있는 사원수 조회


-- 매니저가 없는 사원수 조회 : NULL 데이터는 COUNT 함수로 체크 불가


-- 총급여합계, 평균급여, 최고급여, 최저급여 조회


-- 입사일이 가장 오래된 사원, 가장 최근 입사한 사원


-- 2) GROUP BY : 부분합계를 구할때 사용
-- 형식 : SELECT [컬럼리스트,...], [부분합을 구할 컬럼명]  FROM 테이블명
--         GROUP BY [부분합을 구할 컬럼명]
--         WHERE [조건 검색]

-- 부서별 사원수 조회
SELECT DEPTNO,COUNT(ENAME) FROM EMP GROUP BY DEPTNO;

-- 사원번호별 사원수 조회
SELECT EMPNO,COUNT(ENAME) FROM EMP GROUP BY EMPNO;

-- 부서별 최고급여, 최저급여를 조회
SELECT DEPTNO, MAX(SAL), MIN(SAL) FROM EMP GROUP BY DEPTNO;

-- 직무별 최고급여, 최저급여를 조회
SELECT MAX(SAL), MIN(SAL) FROM EMP GROUP BY JOB;

-- 입사년도별 사원수 조회


-- 입사년도, 입사월별 사원수 조회



-- 3) HAVING 절 : GROUP BY 한 결과에 대한 조건절
-- EMP 테이블의 부서별 평균급여 조회
-- 평균급여가 2000 이상인 부서만 조회
SELECT DEPTNO, FLOOR(AVG(SAL)) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) >= 2000;

-- 직무별 최고급여, 최저급여를 조회
-- 최고급여가 2500 이상인 사원들 조회


-- 입사년도별 최고급여, 최저급여를 조회
-- 최고급여가 3000 이하, 최저급여는 800 이상인 사원들 조회


-- 4) ROLLUP/CUBE 함수 : 그룹핑한 결과에 추가정보를 출력 형식
-- 형식 : GROUP BY [그룹핑할 컬럼] ROLLUP/CULE([그룹핑할 컬럼])

-- 입사년도별 사원수 조회 : ROLLUP 함수 사용
SELECT SUBSTR(HIREDATE,1,2), COUNT(*) FROM EMP
GROUP BY ROLLUP(SUBSTR(HIREDATE,1,2))
ORDER BY SUBSTR(HIREDATE,1,2);

-- 부서별 총급여를 구하고 ROLLUP 함수를 적용
-- 금액은 3자리 구분, 통화기호 표시
SELECT NVL(TO_CHAR(DEPTNO) ,'총합계') 부서별,
          TO_CHAR(SUM(SAL),'L999,999') 급여합계 
FROM EMP
GROUP BY ROLLUP(DEPTNO)
ORDER BY DEPTNO;

-- 부서별 직무의 총급여 조회 : ROLLUP 함수 사용
SELECT NVL(TO_CHAR(DEPTNO),'총급여') 부서별,
TO_CHAR(SUM(SAL),'$999,999') 급여합계, NVL(JOB, '합계') 직무
FROM EMP
GROUP BY ROLLUP(DEPTNO,JOB);

-- 입사년도별 사원수 조회 : CUBE 함수 사용


-- 부서별 직무의 총급여 조회 : CUBE 함수 사용
SELECT NVL(SUBSTR(HIREDATE,1,2), '총인원수') 입사년도, 
            COUNT(*) 사원수
FROM EMP
GROUP BY CUBE(SUBSTR(HIREDATE,1,2))
ORDER BY SUBSTR(HIREDATE,1,2);
-- 10번 부서의 사원들의 사원번호, 사원명, 입사일, 급여, 부서번호를 조회


-- 30번 부서의 사원들의 사원번호, 사원명, 입사일, 급여, 부서번호를 조회


-- 10번 부서의 사원과 30번 부서의 사원 조회결과를  UNION을 사용하여 출력

-- 10번 부서의 사원과 30번 부서의 사원 조회결과를  UNION ALL을 사용하여 출력