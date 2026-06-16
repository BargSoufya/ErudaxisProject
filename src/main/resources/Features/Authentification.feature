@login
Feature:  Authentification page

Scenario Outline: AuthentificationPage

Given admin est sur la page d authentification
When admin remplit le champ email "bargaoui.aycha@gmail.com" et  mdp "Aycha@2026!" 
Then admin click on "<role>"
Then la page menu est affiché "<menu>"

Examples:
|role|menu|
|college|college|
|lycee|lycee|
