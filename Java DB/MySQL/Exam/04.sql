DELETE FROM customers 
WHERE
    id NOT IN (SELECT 
        customer_id
    FROM
        orders);