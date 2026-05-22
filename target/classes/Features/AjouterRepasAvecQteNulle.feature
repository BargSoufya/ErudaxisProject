Feature: Ajouterun nouveau repas 



Background:
    Given l admin est authentifié par l'email "bargaoui.aycha@gmail.com" et le mot de passe "Aycha@2026!"
    And l admin choisit le rôle "college"
    When l admin clique sur le menu "Cantine"
    Then le sous-menu "Gestion Cantine" s affiche
    When l admin clique sur le sous-menu "Gestion Cantine"
    Then la page "Gestion de la Cantine" s affiche
    When l admin clique sur le bouton Ajouter un repas

 Scenario: Ajouter un nouveau repas avec quantite nulle 
 When l admin clique sur le bouton ajouter un repas avec les informations suivantes :
      | Nom du repas | Poulet                           |
      | Catégorie    | Diner                             |
      | Emoji        | 🍗|
      | Date         | 30/08/2026                        |
      | Description  | poulet rotie   |
      | Prix         | 30                              |
      | Quantité     | 0                               |
    Then l admin clique sur créer le repas et un message d erreur indique que  la quantité ne doit pas être nulle

