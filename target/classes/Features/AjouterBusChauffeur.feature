Feature: Ajouter un nouveau bus

 Background:
    Given l admin est authentifie avec "bargaoui.aycha@gmail.com" et "Aycha@2026!" et choisit "college"
  When l admin clique sur le menu Bus "Gestion des Bus"
    When l admin clique sur le sous-menu Bus "Bus et Chauffeurs"
   Then la page bus et chauffeurs s affiche "Liste des Bus"
  Scenario: Afficher le formulaire d ajout d un bus

    When l admin clique sur le bouton Ajouter un bus le formulaire d ajout d un bus s affiche
    
  Scenario: Afficher le formulaire chauffeur
	Then l admin clique sur le bouton de navigation pour changer vers l interface chauffeur 
	When l admin clique sur le bouton ajouter un chauffeur le formulaire de chauffeur s affiche 
	

	Scenario: Ajouter un chaffeur avec des informations valides
	Then l admin clique sur le bouton de navigation pour changer vers l interface chauffeur 
	When l admin clique sur le bouton ajouter un chauffeur le formulaire de chauffeur s affiche 
	Then l admin remplit les champs du formulaire par les informations suivantes:
	|Prénom|Ahmed |
	|Nom| ben mostafa|
	|Email| ahmed@gmail.com|
	|CIN| 418718477|
	|Numéro de Téléphone |6651548721|
	|Adresse|15 rue de la république |
	|Pays|France|
	|Ville|Paris|
<<<<<<< HEAD
	Then l admin cliquer sur le bouton créer le chauffeur et un message de succès s affiche 
=======
	then l admin cliquer sur le bouton créer le chauffeur et un message de succès s affiche 
>>>>>>> 35f8044f97b6dbaee155f9ff90c8a3ddde73f62e
	
	
	Scenario: Ajouter un chaffeur avec Nom existant
	