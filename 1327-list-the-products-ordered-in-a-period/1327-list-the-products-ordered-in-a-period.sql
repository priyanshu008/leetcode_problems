# Write your MySQL query statement below

select p.Product_name product_name, sum(o.unit) as unit
FROM Products p left join Orders o
ON o.product_id = p.product_id
where o.order_date like "2020-02%"
group by product_name
having unit >= 100;