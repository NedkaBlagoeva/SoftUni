CREATE VIEW `v_employees_job_titles` AS
SELECT concat_ws(' ', first_name, middle_name, last_name) AS `Full Name`, job_title
FROM employees;