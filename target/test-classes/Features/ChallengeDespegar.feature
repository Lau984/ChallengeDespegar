#Author: Laura Moreno
#Keywords Summary : Challenge despegar
#Maven
#Patr�n de dise�o: POM
#Versi�n de Chrome: 97
@tag
Feature: Challenge despegar
  Se realiza el flujo para comprar un tiquete de Medell�n a Bogot� en despegar.com en el d�a siguiente al actual.

  @Test1
  Scenario: Buy a ticket to travel in despegar.com
    Given Despegar.com is displayed
    When Configure the page
    And Fill fields about destination and date
    And Search and select a ticket
    Then Check out page is displayed

