
Feature:  Ajouter un repas	
Scenario: Acceder au formulaire d ajout d un repas via le menu cantine  



Background:
Given l admin est authentifie par  le bon "bargaoui.aycha@gmail.com" et le bon password "Aycha@2026!" And  choisit le role "college"

When l admin clique sur le menu "Cantine"
Then le sousmenu "Gestion Cantine" s affiche 

When  l admin clique sur le sous-menu "Gestion Cantine"
Then  la page "Gestion de la Cantine" s affiche 

When   l admin clique sur le bouton ajouter un repas 
Then le formulaire d ajout dun repas s  affiche

