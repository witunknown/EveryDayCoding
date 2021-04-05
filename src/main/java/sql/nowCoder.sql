/*/**
 * @title
 * @description
 * @author admin
 * @updateTime 2021/3/28 22:38
 *mysql 启动：cd d:/mysql/bin
 *net start mysql
 */


CREATE DATABASE test_demo;

/**/
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

SELECT emp_no,COUNT(*) FROM salaries GROUP BY emp_no HAVING COUNT(*) >15;




