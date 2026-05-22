Feature: Ajouter un nouveau bus

 Background:
    Given l admin est authentifie avec "bargaoui.aycha@gmail.com" et "Aycha@2026!" et choisit "college"
  When l admin clique sur le menu Bus "Gestion des Bus"
    When l admin clique sur le sous-menu Bus "Bus et Chauffeurs"
   Then la page bus et chauffeurs s affiche "Liste des Bus"
  Scenario: Afficher le formulaire d ajout d un bus

    When l admin clique sur le bouton Ajouter un bus le formulaire d ajout d un bus s'affiche
    
  Scenario: Afficher le formulaire chauffeur
	Then l admin clique sur le bouton de navigation pour changer vers l interface chauffeur 
	When l admin clique sur le bouton ajouter un chauffeur le formulaire de chauffeur s affiche 
	
	



	
	