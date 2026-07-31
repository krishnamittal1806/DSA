# Write your MySQL query statement below
SELECT unique_id , name FROM employees as e
LEFT JOIN EmployeeUNI as eu 
on e.id = eu.id;
