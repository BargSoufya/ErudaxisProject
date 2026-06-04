Feature: Ajouter un nouveau chauffeur sans Nom

 Background:
    Given l admin est authentifie avec "bargaoui.aycha@gmail.com" et "Aycha@2026!" et choisit "college"
  When l admin clique sur le menu Bus "Gestion des Bus"
    When l admin clique sur le sous-menu Bus "Bus et Chauffeurs"
   Then la page bus et chauffeurs s affiche "Liste des Bus"
   Then l admin clique sur le bouton de navigation pour changer vers l interface chauffeur 
	When l admin clique sur le bouton ajouter un chauffeur le formulaire de chauffeur s affiche 
	
	Scenario: Ajouter un chauffeur avec Nom vide 
	Then  l admin  laisse le champ Nom " " 
	Then l admin sasit le reste des infortmations :
	|Prénom | Maxime|
	|Nom |        |
	|Email | maxime01@gmail.com|
	|CIN | 0741842518 |
	|Flag Pays|+ 33|
	|Numéro de Téléphone |06248415|
	|Adresse| Paris05  |
	|Pays | France    |
	|Ville | Paris   |
	
	Then l 'admin clique sur le bouton creer le chauffeur
