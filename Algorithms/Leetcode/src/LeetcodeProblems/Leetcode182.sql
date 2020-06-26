/*
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
 */

 SELECT DISTINCT a.Email
 FROM Person a, Person b
 WHERE a.Email = b.Email AND a.Id != b.Id

 SELECT DISTINCT Email
 FROM (
 SELECT Email, count(Email) as num
 FROM Person
 GROUP BY Email
 ) AS emailTable
 WHERE num > 1