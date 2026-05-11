Feature: Ajouter un repas avec date passee

  Background:
    Given l'admin est authentifié par l'email "bargaoui.aycha@gmail.com" et le mot de passe "Aycha@2026!"
    And l'admin choisit le rôle "college"
    When l'admin clique sur le menu "Cantine"
    Then le sous-menu "Gestion Cantine" s'affiche
    When l'admin clique sur le sous-menu "Gestion Cantine"
    Then la page "Gestion de la Cantine" s'affiche
    When l'admin clique sur le bouton "Ajouter un repas"
   
    Scenario: Ajouter un nouveau repas avec datre dans le passe
    
   
   And l admin saisit les informations du repas suivantes :
  | Nom du repas | Humberger              |
  | Catégorie    | Déjeuner               |
  | Emoji        | 🍔                     |
  | Date         | 01/05/2026             |
  | Description  | un hamburger délicieux |
  | Prix         | 20                     |
  | Quantité     | 2                      |
    When l admin clique sur le bouton Créer le repas
    Then un message d erreur sous le champ date s affiche
And le repas n'apparaît pas dans la liste des repas et quite le formulaire
    