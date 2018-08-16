# codingtestdana
Code Test Android Studio / AppStud / 16-08-2018 / Dana Lepileur
# Création de l'application
Application nommée codingtestdana, la première activité s'appelle MainActivity et représente l'affichage de la partie Map de l'application.
# Interface
Pour l'interface utilisateur, il est important de séparer les éléments. Celui qui prend tout l'écran est un relative layout, celui-ci comprend un linear layout en horizontale afin d'avoir la carte ou la liste prenant 90% de l'écran puis la barre de navigation en bas prenant 10% de l'écran. 
Dans la barre de navigation, on doit y mettre les deux boutons dans un linear layout vertical où chacun des linear prend 50% de la largeur du téléphone.
# Différentes activités
Comme il est préciser dans le sujet, l'application possède une partie Map et une partie List dont l'utilisateur peut naviguer entre les deux. Pour se faire, il a fallu, grâce à l'id des boutons, créer une action Listener lié au bouton. En créant une autre activité ListActivity, le bouton List de la MainActivity va ainsi se rediriger vers le layout de la deuxième activité, vice-versa.
- Le changement entre les deux activités est un peu brusque (animation d'une nouvelle application qui se lance). Mais pour raison de temps et du fait que c'est ce que l'on m'a apprit, je n'ai pas cherché meilleur résultat.

# Ajout de la map
Pour ajouter la map, je me suis aidée de GoogleMaps Plateform https://developers.google.com/maps/documentation/android-sdk/map-with-marker qui proposait un exemple de Maps sur un GitHub https://github.com/googlemaps/android-samples. 

# Localisation de l'utilisateur
