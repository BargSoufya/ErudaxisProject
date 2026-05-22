Feature: Recherche facture d un etudiant 

 Background:
     Given l admin est authentifie avec "bargaoui.aycha@gmail.com" et "Aycha@2026!" et choisit "college"
    When l admin clique sur le menu "Cantine"
    When l admin clique sur le sous-menu "Synthèse des Paiements"
    Then la page Portail de Gestion des Paiements s affiche
   
   Scenario: Rechercher facture etudiant 
 When l admin remplit les champs de recherche suivants :
 
      | Étudiant  |  Nour bensaleh |
      | Début      | 30/10/2025 |    
      | Fin        | 30/12/2026 |
      
 And l admin clique sur le bouton Rechercher et la facture de l etudiant s affiche
 
 