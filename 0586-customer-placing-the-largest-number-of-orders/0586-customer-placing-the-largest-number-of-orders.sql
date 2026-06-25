# Write your MySQL query statement below
-- select customer_number
-- from Orders 
-- group by customer_number order by count(order_number) desc limit 1;

WITH cnts AS (
    SELECT customer_number, COUNT(order_number) AS order_count
    FROM Orders
    GROUP BY customer_number
)
SELECT customer_number from cnts where order_count = (select max(order_count) from cnts);
