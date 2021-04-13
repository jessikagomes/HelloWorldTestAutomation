Feature: Consulting course on the website

	Scenario: Happy path
		Given the user acces the Iterasys webpage
		When I search for "teste de software"
		And show a list of courses
		And i click on Incio Rapido em Teste de software
		Then I see the duration of the course is "60" hours