Feature: Ajouter un repas avec nom vide

  Background:
    Given l'admin est authentifié par l'email "bargaoui.aycha@gmail.com" et le mot de passe "Aycha@2026!"
    And l'admin choisit le rôle "college"
    When l'admin clique sur le menu "Cantine"
    Then le sous-menu "Gestion Cantine" s'affiche
    When l'admin clique sur le sous-menu "Gestion Cantine"
    Then la page "Gestion de la Cantine" s'affiche
    When l'admin clique sur le bouton "Ajouter un repas"
   

  Scenario: Ajouter un nouveau repas avec nom vide
    And l dmin laisse le champ "nom du repas" vide
    And l admin saisit les informations suivantes :
      |Nom du repas |                    |
      | Catégorie   | Dîner                  |
      | Emoji       | 🥗 |
      | Date        | 28/06/2026                |
      | Description | une salade bien garnie  |
      | Prix        | 10                      |
      | Quantité    | 1                         |
    When l admin clique sur le bouton Créer le repas
    Then un message d erreur indique que le nom est obligatoire "message"
    And le repas n'apparaît pas dans la liste des repas et quite le formulaire
    
    
