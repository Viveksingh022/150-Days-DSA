# Write your MySQL query statement below
-- SELECT  EmployeeUNI.unique_id, Employees.name
-- FROM Employees
-- LEFT JOIN EmployeeUNI
-- ON Employees.id = EmployeeUNI.id;

-- LEFT JOIN QUERY 

-- RIGHT JOIN 

SELECT  EmployeeUNI.unique_id, Employees.name
FROM EmployeeUNI
RIGHT JOIN Employees
ON Employees.id = EmployeeUNI.id;