Feature: Modifier un repas existant 
 Background:
    Given l admin est authentifié par l'email "bargaoui.aycha@gmail.com" et le mot de passe "Aycha@2026!"
    And l admin choisit le rôle "college"
    When l admin clique sur le menu "Cantine"
    Then le sous-menu "Gestion Cantine" s affiche
    When l admin clique sur le sous-menu "Gestion Cantine"
    Then la page "Gestion de la Cantine" s affiche
    
    Scenario: modifier un repas deja existant
    
    Then l admin clique sur les trois points du repas selectionné et  un menu de deux choix s affiche
    When l admin clique sur le bouton modifier, le formulaire de modification s affiche
    When l admin modifie les informations suivantes :
    |Nom du repas |    Salades                |
      | Catégorie   | Déjeuner                  |
      | Emoji       | 🥗 |
      | Date        | 28/07/2026                |
      | Description | une salade au poulet bien garnie  |
      | Prix        | 10                      |
      | Quantité    | 2                        |
    Then l'admin clique sur le bouton modifier le repas 
   
