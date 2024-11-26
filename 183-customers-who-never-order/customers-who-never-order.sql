# Write your MySQL query statement below
select name as customers from customers left join orders on customers.id=orders.customerId group by customers.id having count(orders.id)=0;