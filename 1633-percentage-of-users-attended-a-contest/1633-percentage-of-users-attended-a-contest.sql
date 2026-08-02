# Write your MySQL query statement below
SELECT contest_id  , ROUND( ( COUNT( DISTINCT user_id) * 100 / (SELECT count( user_id) FROM USERS )) , 2) AS percentage
FROM REGISTER 
GROUP BY contest_id
ORDER BY percentage DESC , contest_id; 
