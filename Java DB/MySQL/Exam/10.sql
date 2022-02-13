DELIMITER %%
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (SELECT 
    COUNT(*)
FROM
    customers AS c
        LEFT JOIN
    orders AS o ON o.customer_id = c.id
        LEFT JOIN
    orders_products AS op ON o.id = op.order_id
        LEFT JOIN
    products AS p ON op.product_id = p.id
    WHERE c.first_name = name
    GROUP BY customer_id);
END
%%