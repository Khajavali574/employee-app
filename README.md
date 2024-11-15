# employee-app



## Getting started

Swagger url : http://localhost:8080/swagger-ui/index.html

Application URL:
Post: http://localhost:8080/employee/create
GET:  http://localhost:8080/employee/department/HR
GET:  http://localhost:8080/employee/empname/K
GET:  http://localhost:8080/employee/sort/deptAndEmpId
GET:  http://localhost:8080/employee/HR/sort/empName
GET:  http://localhost:8080/employee/department/empid/1

How to run the app:
Steps:
1.Clone the app.
2.Build the app.
3.Run the command java -jar employee-app.jar

Request to Create Employees:

HR Department Employee:
-----------------------
{
"departmentName":"HR",
"employeeNames":["Khaja","Vali"]
}

HR Department Employee:
-----------------------
{
"departmentName":"Engineering",
"employeeNames":["Ram","Sam"]
}

HR Department Employee:
-----------------------
{
"departmentName":"QA",
"employeeNames":["Jack","Euvin","Pitor"]
}