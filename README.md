# scientificJournalApp


https://user-images.githubusercontent.com/51009647/208567405-f472b885-5616-416c-b8b4-f75239fbb1f4.mp4

> ## Guide utilisateur :
>![image](https://user-images.githubusercontent.com/51009647/208567970-a8a6e804-0d95-43a4-91b4-91a259784264.png)

> Cette application constitue une application Spring Boot, afin d’exécuter l’application, il faut s’assurer tout d’abord que toutes les dépendances Maven sont chargé dans le projet.
Ensuite, il faut modifier les propriétés, surtout de base de données dans le fichier application.properties afin d’assurer une connexion correct avec la base de données, et assurer le bon fonctionnement de l’application sans générer d’exception liées aux requêtes SQL.
Puis, il faut se diriger vers la classe ScientificJournalAppApplication.java qui est l’entrée de l’application (Main class for exécution), afin de lancer l’exécution.
Pour accéder à l’application, il faut se connecter à l’adresse localhost avec le port 8080.
Exemple : localhost :8080/displayCategories 
Cette adresse va être le ‘entry point’ pour accéder à l’application, on aura comme résultat une redirection vers la page d’authentification, qui a été imposé par Spring Security. Si l’utilisateur est connecté correctement, il peut accéder aux ressources qui lui sont autorisés. Dans ce cas par exemple, il peut voir les catégories d’articles affichés avec des contraintes d’accès aux ressources de cette interface selon son rôle dans le système (admin, simple user…).
