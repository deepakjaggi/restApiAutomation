Feature: Testing Login Service 

#-----------Example of taking the data into collection Object
Scenario: verify Login 
	Given LoginData 
		| tc     | useCase       | mobileNumber | pin  | errorCode | errorMessage | 
		| 001_TC | SUCCESS_LOGIN | 92511830     | 1236 | 9000      | Success      | 
	When user will hit the login service 
	Then verify test result 
	
Scenario: verify Login for Blank Mobile Number 
	Given LoginData 
		| tc     | useCase             | mobileNumber | pin  | errorCode | errorMessage            | 
		| 002_TC | BLANK_MOBILE_NUMBER |              | 1236 | 9002      | mobile Number not valid | 
	When user will hit the login service 
	Then verify test result 
	
	
