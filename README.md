# Cahier des charges pour le projet « Barges dans un réseau espace-temps »

Réalisé dans le cadre de l&#39;EC
 « Modélisation et Simulation des Systèmes Complexes » en M2 TNSID
 Année 2021/2022

## 1. Formuler le problème

L&#39;objectif est de simuler le transport de containers selon différents modes de transport (barges, train, camions). L&#39;organisation des « services » (i.e. dates/heures de passages en différents points/terminaux) est supposée précalculée par un modèle d&#39;optimisation, sans tenir compte d&#39;aléas (climatiques, pannes, retards…).

## 2. Préciser les objectifs et organiser le projet

### 2.1. Objectifs du projet

Il convient avant tout de vérifier si les données nécessaires à la modélisation sont disponibles, fiables et actualisée (i.e. à jour) sinon la modélisation est impossible/inutile. Le modèle de simulation focalise sur les barges.

Les autres modes (train et camions) sont :

- dans un premier temps hors du périmètre du modèle de simulation et supposés toujours disponibles (i.e. prêts à transporter) ;
- dans un second temps disponibles à certaines périodes (problématiques de base en synchromodalité) ;
- en extension du modèle, comment serait-il possible d&#39;intégrer plusieurs modes de transport dans un modèle de simulation (ou plusieurs modèles en co-simulation) ?

Expliquée simplement, la synchromodalité consiste à synchroniser plusieurs modes de transport (trains, camions, barges) de manière à supprimer ou au moins limiter les attentes lors d&#39;un changement de mode.

Le recours à la co-simulation (i.e. plusieurs modèles de simulation cohabitent ± associés à plusieurs simulateurs) n&#39;est pas justifiée dans le cadre de ce projet.

Pour le projet en M2 TNSID, il faudra déterminer en ce point les objectifs, la précision et le périmètre (ce qui sera simulé) requis.

→ Précision en terme de container : 1 container est indivisible (on compte le nombre de containers). Dans la réalité, il existe plusieurs types &amp; tailles de containers (20 pieds, 40 pieds). Nous utiliserons une unité standard, nommée « TEU » (Twenty-foot Equivalent Unit) pour mesurer les quantités transportées.

Dans le cadre d&#39;un projet de Master, des extensions sont possibles.

En nous basant sur une modélisation dirigée par la performance, il faut déterminer ce qu&#39;il est nécessaire de modéliser et calcul pour obtenir les indicateurs de performance requis par le.s décideur.s dans votre modèle de simulation :

- (a) au niveau des services → individualisés → faut-il en faire des objets ?

    - nombre de services pour trouver des solutions réalisables

    - capacité du service en terme de nombre de barges qui l&#39;empruntent
        - pouvoir en déduire le nombre de containers transportés

- (b) au niveau des barges → individualisées ? → pour pouvoir les situer (animation) + pour les pannes et les maintenances.

    - nombre de barges pour trouver des solutions réalisables

    - taux d&#39;occupation des barges (nombre containers / nombre maxi de containers)

    - position (N° terminal où se trouve la barge)

- (c) au niveau des containers → pas individualisés → agrégés par type (on ne connaît que le nombre qui circule par type)

    - nombre de containers (pour mesurer le nombre de containers transportés)

- y en a t-il d&#39;autres ?
    - Comment modéliser les demande de transport
    - Identifiant de la demande (N°)
    - Nombre de containers + leurs types
    - Origine et destination
    - date de la demande de transport
    - date de disponibilité des containers au point de départ
    - date à laquelle les containers sont censés arriver au terminal d&#39;arrivée
    - priorité associée à la demande (prix qui a été payé, l&#39;urgence...)

Posez-vous la question du niveau de détail requis pour calculer ces indicateurs de performance. Au strict minimum, pour ce projet, la simulation doit fournir des résultats numériques en ce qui concerne l&#39;utilisation [moyenne] des ressources. La simulation doit également permettre de trouver rapidement des scénarios alternatifs pour résoudre les problèmes liés aux aléas ou remonter une information sur l&#39;impossibilité de trouver une solution si cela se produit.

La simulation doit comporter une interface graphique pour visualiser interactivement la circulation des barges.

### 2.2. Organisation du projet

Que ce soit dans cette sous-section ou dans une sous-section antérieure, il faut généralement définir les points d&#39;étapes sous forme de « livrables » et de calendriers de visites/réunions. Ceci peut être réalisé sous forme d&#39;un diagramme de Gantt par exemple.

Dans un cas réel, selon la complexité du projet, il peut être nécessaire de mettre en place une équipe projet, un outil de gestion de projet [informatique], un traqueur de bugs…

Pour le projet en M2 TNSID, il faudra définir très rapidement les équipes projet (nombre, composition) et dimensionner le projet en conséquence.

## 3. Effectuer la modélisation et collecter les données

### 3.1. Choix du type de modèle

Le choix du modèle est effectué en fonction des étapes précédentes en affinant le cahier des charges si nécessaire. En respectant ce qui a été déterminé en termes d&#39;objectifs, de précision et de périmètre (ce qui sera simulé) requis. Il peut être nécessaire de re-déterminer ces points en les affinant.

L&#39;aspect déterministe ou stochastique est aussi à intégrer.

Pour le projet en M2 TNSID, le modèle se base sur des changements d&#39;états discrets, le temps est continu et l&#39;espace n&#39;est pas pris en compte directement. Les aléas/pannes à considérer impliquent un modèle stochastique. Il faudra définir/affiner ensemble les objectifs, la précision et le périmètre (ce qui sera simulé) requis.

Attention à ne pas « réinventer la roue » en cette étape : s&#39;il existe des modèles efficaces déjà publiés et/ou des représentations et/ou structures de données (et/ou…) utilisées dans le domaine relatif à la simulation, il faut les utiliser.

En terme de modèles existants pour le problème considéré, nous disposons d&#39;un ensemble de problèmes voisins liés à l&#39;ordonnancement cyclique de tâches (sur des processeurs, sur des serveurs…) avec des contraintes ± différentes.

Des modèles (d&#39;optimisation, de simulation) existent déjà et consulter la littérature du domaine s&#39;avère nécessaire en ce point...

L&#39;aspect cyclique est très important : les barges passent par exemple toutes les semaines, ou deux fois par semaine ou… de même que les tâches périodiques/cycliques se répètent au bout d&#39;un certain nombre d&#39;unité de temps…

### 3.2. Conception du modèle

Les sous-sections précédentes nous conduisent a priori à choisir un modèle à événements discrets. Pour rappel, la simulation d&#39;un modèle à évènements discrets consiste à gérer une liste courante d&#39;évènements programmés, et, successivement :

- faire avancer le temps jusqu&#39;au prochain évènement programmé ;
- exécuter l&#39;évènement : modifier l&#39;état et la liste d&#39;évènements.

#### 3.2.1. Acteurs ? Cas d&#39;utilisation du modèle, du simulateur ?

Use cases ? → À définir ? → Qui déclenche quoi à quel moment ? → Quels sont les acteurs ? Quels sont leurs rôles ? → Faut-il tenir compte des ressources humaines ? → Conséquences à prendre en compte au niveau des périodes d&#39;ouverture/fonctionnement des terminaux/barges…

Deux niveaux à distinguer :

- les utilisatrices/utilisateurs du modèle et/ou du simulateur à réaliser, les scénarios d&#39;utilisation du modèle de simulation (pour quoi faire, dans quels buts…) ;
- les acteurs « simulés », intégrés à la simulation (par exemple les clients qui vont soumettre des demandes de transport).

#### 3.2.2. Représentation usuelle d&#39;une simulation : réseau espace-temps

Dans bon nombre de domaines de la simulation, une « représentation usuelle » d&#39;une solution au problème, de la simulation en cours, ou encore d&#39;une formalisation (sous forme de graphe par exemple) existe...

Pour le problème qui nous intéresse, il s&#39;agit des réseaux espace-temps...

En terme de structure de données et/ou de représentation usuelle pour le problème considéré, l&#39;utilisation d&#39;un « réseau espace-temps » s&#39;avère opportun pour représenter la circulation des barges. Des exemples de réseaux espace-temps sont fournis dans le Cours N°2.

Le pas de temps pour les réseaux espace-temps considérés dans le simulateur devraient idéalement être un paramètre de simulation (i.e. un déplacement horizontal élémentaire dans un réseau espace-temps vaut un jour, 1/2 jour, 1 heure ou …) → Pour simplifier les choses dans le projet, nous supposerons que le pas de temps dans les réseaux espace-temps vaut 1/2 journée avec des arrivées supposées fixes en début de chaque demi-journée : 8H le matin (période 8H-12H) et 13H l&#39;après-midi (période 13H-17H).

En cas de problème pour réaliser le modèle, vous pouvez considérer un pas de temps d&#39;un jour si cela semble plus simple à implémenter.

Pour le projet en M2 TNSID, je vous aiderai en pas à pas dans la conception du modèle (pas sur les aspects codage en C++ que vous devez maîtriser, mais sur l&#39;architecture logicielle du modèle en lui-même).

#### 3.2.3. Sous-système physique - Ressources matérielles et humaines – Éléments constitutifs et état du modèle de simulation

La liste des ressources matérielle et humaines est la suivante:

Barges : Individualisées/Groupées\_par\_type/Agrégées ? Nombre ? Types ? Caractérisées par ?

Containers : Individualisés/Groupés\_par\_type/Agrégés ? Nombre ? Types ? Caractérisés par ?

Services : Individualisés/Groupés\_par\_type/Agrégés ? Nombre ? Types ? Caractérisés par ?

Demandes : …

→ cf les réponses en section 2.1

Demande → arrivée des containers au terminal de départ → circulation des containers sur les barges → arrivée des containers → sortie des containers

Après avoir caractérisé la liste et les types des ressources à prendre en compte suite aux entretiens (représentés par la section 2.1), il est nécessaire de caractériser les états des ressources considérées pour la simulation.

Attention à faire le lien entre demande (une liste de containers avec OD), service (supportent les barges), barges (transportant les containers) et containers (composant la demande)

L&#39;état du modèle de simulation en lui-même est défini par la liste des variables décrivant l&#39;état des constituants du modèle à laquelle on ajoute généralement des variables utilisées pour gérer le modèle en lui-même (exemple de l&#39;horloge, de « variables/paramètres » associé(e)s au générateur de nombre pseudo-aléatoire, des [noms de] fichiers utilisés en entrée/sortie…).

État du système → État du modèle ↔ État du simulateur ⇐\&gt; Indicateurs de performance

Quelles sont les « variables » qui caractérisent chaque élément du modèle de simulation ?

**(a) états d&#39;une demande**

- Attendue → La demande de transport est formulée mais les containers ne sont pas encore arrivés sur le quai de chargement

- ArrivéeO → [Tous] les containers sont arrivés sur le quai de chargement du terminal d&#39;origine

- EnTransport → containers transitent sur un leg (arcs non horizontaux sur le réseau espace-temps)

- EnAttente → container sur un quai ou en attente dans une barge (arcs horizontaux sur le réseau espace-temps)

- [ChargementDechargement] → containers en chargement/déchargement → pour les scenarii ultérieurs

- ArrivéeD → [Tous] les containers sont arrivés au terminal de destination (on suppose un déchargement immédiat, sauf s&#39;il y a un arcs horizontal au niveau du réseau espace-temps)

Pour les premiers scenarii, on peut supposer que chaque demande est indivisible (i.e. elle voyage en une seule fois). Pour les scenarii suivants, il faut considérer des demandes « fractionnables » (surtout lorsque l&#39;on tient compte des capacités des barges, des services et des terminaux).

→ Pose un problème : comment localiser « une demande » dans le réseau espace-temps (facile si non fractionnable, plus compliqué sinon).

- Comment identifier de manière unique une demande et les « fragments » de cette commande
    - Identifiant unique (entier) et si on suppose 9 fragments maxi :

- si l&#39;ID se termine par zéro c&#39;est une commande non fractionnée

- si l&#39;ID ne se termine pas par zéro alors c&#39;est un fragments

Dans les deux cas ID/10 donne le numéro de commande (i.e. son ID).

Ce &quot;truc&quot; permet de repérer la position de chaque demande et/ou de chaque fragment dans le réseau espace-temps → la position fait partie de l&#39;état de la demande (ou du fragment).

Attention à mémoriser la date à laquelle la demande est dans la position indiquée.

**(b) états d&#39;une barge**

- EnAttente → au niveau d&#39;un quai sur un terminal (arcs horizontaux du réseau espace temps dans les premiers scenarii)

- EnTransport → sur un arc non horizontal du réseau espace-temps

- [ChargementDechargement] → containers en chargement/déchargement → pour les scenarii ultérieurs

- [EnPanne] [EnReparation] → plus tard !

- [EnAttenteEcluse] → Non pris en compte

→ Position : pour localiser « une barge » dans le réseau espace-temps (Identifiant du terminal où elle se trouve)

**(c) états d&#39;un service**

- Ouvert → Le service est utilisable

- Fermé → Le service n&#39;est pas utilisable

- [Liste des barges en chaque terminal, la liste des barges « sur » chacun de ses arcs]

**(d) états d&#39;un container** → est-ce utile ? → faut-il individualiser ?

- [Plein ou vide ? % remplissage ?] + voir les aspects repositionnement (i.e. remettre à disposition des containers vides) → trop complexe pour le projet en M2 TNSID

- EnAttente → attente de chargement/déchargement au niveau d&#39;un quai sur un terminal (arcs horizontaux du réseau espace temps dans les premiers scenarii)

- EnTransport → sur un arc non horizontal du réseau espace-temps

- [ChargementDechargement] → containers en chargement/déchargement → pour les scenarii ultérieurs

- [EnPanne] [EnReparation] → plus tard !

- [EnAttenteEcluse] → Non pris en compte

→ Position : pour localiser « une barge » dans le réseau espace-temps (Identifiant du terminal où elle se trouve)

**(e) états d&#39;un terminal** → est-ce utile ? → faut-il individualiser ?

- Ouvert → Le terminal est utilisable

- Fermé → Le terminal n&#39;est pas utilisable

- [Liste/nombre des barges au niveau du terminal]

- [Liste/nombre des containers au niveau des quais du terminal]

#### 3.2.4. Sous-système logique – Principe de fonctionnement « de base »

Il s&#39;agit de décrire le fonctionnement « de base du modèle de simulation », autrement dit qu&#39;est-ce qui déclenche tel ou tel événement en mode de fonctionnement nominal. Les différents scénarios à tester sont plutôt étudiés dans la partie décisionnelle où l&#39;on va ± volontairement pousser le modèle de simulation vers des scenarii extrême pour voir « ce qu&#39;il se passe si » (what-if), pour évaluer des gains, des pertes, des reconfigurations...

Dans la section actuelle, il s&#39;agit plus de décrire, éventuellement sous forme de scenarii de plus en plus réalistes, les règles qui régissent le fonctionnement [normal/nominal] du système modélisé et donc « comment s&#39;anime le modèle de simulation ».

**(A) Premier scénario en mode minimaliste (non réaliste)**

(a) pas de panne ni de retard (i.e. soit les départs/arrivées se font à 8H le matin, soit les départs/arrivées se font à 13H l&#39;après-midi, en considérant juste la demi-journée qui correspond si nous avons un réseau espace-temps avec une résolution temporelle d&#39;une demi-journée)

(b) les demandes sont traitée dans l&#39;ordre FIFO (i.e. dans l&#39;ordre d&#39;arrivée, pas de priorité, pas de délai de livraison à respecter, pas notion de gain/perte financière)

(c) pour chaque demande, on connaît :

- origine et sa destination (représenté par le sigle &quot;OD&quot;)
- (d) 1 seul service est &quot;emprunté&quot; pour chaque demande entre O et D
- (e) capacité supposée illimitée au niveau de chaque commande, on suppose que la taille maximale de chaque commande est illimitée

(f) capacité supposée illimitée au niveau de chaque service

(g) capacité supposée illimitée au niveau de chaque barge (i.e. dans un premier temps, une barge suffit sur chaque service)

(h) capacité illimitée au niveau de chaque terminal (en terme de stockage de container)

(i) capacité illimité au niveau de chaque terminal en terme de nombre de barges qui peuvent accoster simultanément sur un terminal

(j) demande traitée dès qu&#39;elle arrive dans le système (date de disponibilité == date de chargement dans une ou plusieurs barge(s)) ± dès qu&#39;il y a une barge disponible au niveau du système (sur le réseau espace temps, i.e. arcs horizontaux sur le réseau espace-temps)

(k) containers associés à une demande sont déchargés dès qu&#39;ils arrivent sur le terminal à destination (déchargement immédiat, sauf s&#39;il y a une attente sur le réseau espace-temps, i.e. arcs horizontaux sur le réseau espace-temps)

**(B) Second scénario en mode minimaliste – [plus] réaliste**

Par rapport au scénario précédent, il s&#39;agit de remettre en fonction une ou plusieurs contrainte(s) (de capacités, temporelles…). Par exemple pour le point (a), il faut considérer des pannes/retards, ce qui signifie que les départs/arrivées ne se font plus systématiquement à 8H le matin ou à 13H l&#39;après-midi (selon la demi-journée qui correspond si nous avons un réseau espace-temps avec une résolution temporelle d&#39;une demi-journée). En ce cas, l&#39;heure effective de départ/arrivée correspond à l&#39;heure de début de période (8H ou 13H) à laquelle nous ajoutons un retard mesuré en heures.

Il faut donc proposer un second scénario – pas à pas – qui va conduire à une simulation réaliste.

#### 3.2.5. Sous-système décisionnel – Aide à la décision

Quels sont les points de décision, les scenarii à tester ???

Type de barge à mettre en œuvre : vaut-il mieux une grosse barge ou deux petites ?

Est-ce que l&#39;on peut refuser une demande, est-ce que l&#39;on peut retarder une demande, est-ce que l&#39;on peut fractionner une demande ? Est-ce qu&#39;il faut « sous-traiter » la demande (via un autre mode/transporteur).

Qu&#39;est ce que le client est prêt à payer ? Combien de temps il est prêt à attendre ?

### 3.3. Collecte des données

C&#39;est une étape cruciale pour la modélisation car toute erreur ou oubli dans le recueil des données peut conduire à un modèle de simulation incorrect. Il existe des méthodes dédiées pour cette étape (basées sur le Gemba-Walk, sur une cartographie des ressources &amp; processus…).

Cette étape peut/doit démarrer très tôt idéalement surtout si leur obtention demande du temps, des autorisations et/ou des vérification. Elle se déroule en général en plusieurs fois et en parallèle de la conception du modèle si nécessaire. Attention au piège consistant à collecter plus de données que nécessaire pour concevoir et valider le modèle. Il est préférable de répéter plusieurs fois cette étape en affinant/complétant les données recueillies, voire en focalisant sur un sous-système du système simulé, pour ne disposer « que » des données nécessaires et suffisantes avec « juste la précision nécessaire » au sous-système simulé et/ou au sous-système sur lequel focalise la simulation en vue de mieux comprendre/utiliser le système ou de l&#39;améliorer.

Comme expliqué en Cours N°2, il faut vérifier si les données requises pour les sous-systèmes physique, logique et décisionnel sont bien disponibles, fiables, précises et acquises. Prévoir de lancer une campagne de mesures si tel n&#39;est pas le cas et les outils et le délai nécessaires aux calculs d&#39;ajustements &amp; cie si cela est nécessaire.

Pour le projet en M2 TNSID, je fournirai les données nécessaires et suffisantes au fur et à mesure de l&#39;avancement du projet.

## 4. Coder le modèle

J&#39;impose l&#39;utilisation de Qt5 et C++. Je suggère d&#39;utiliser QtCreator comme IDE.

Pour le projet en M2 TNSID, je vous aiderai si nécessaire s&#39;il y a des soucis lors du codage du modèle, mais pas sur les aspects codage en C++ que vous devez maîtriser.

[après discussion avec vous, le C++ semble problématique → à revoir ensemble]

Quelques question à se poser (et y répondre en codant le modèle) :

1. quelles variables mesurer et comment les observer sur une base de temps ?
2. relation d&#39;entrée sortie ± en fonction du temps (i.e. en fonction du temps que doit donner le modèle de simulation au niveau de ses sorties en fonction de ses entrées ?) ?
3. état initial (+ entrées &amp; sorties) ?
4. transitions d&#39;un état à l&#39;autre, comment les entrées affectent les états et comment les états affectent les sorties ?
5. est-il nécessaire de décomposer hiérarchiquement le modèle (modèles couplés ?) ?
6. mono-modèle ou multi-modèle ?
7. simulation ou optimisation-simulation ?
8. ... ???

Pour le projet en M2 TNSID, nous répondrons ensembles à certaines de ces questions et nous compléterons ce « cahier des charges ».

Pour le projet en M2 TNSID, nous allons au-delà de la « simple » conception d&#39;un modèle de simulation puisque nous réalisons un simulateur (dédié au problème étudié).

### 4.1. Format des fichiers d&#39;entrée

Un numéro unique de scénario est défini pour chaque test effectué. Chaque scénario est associé à quatre fichiers texte fournis en entrée du simulateur :

- \<ID>_services.txt : liste des services ouverts pour le scénario numéro \<ID> ;
- \<ID>_topologie.txt : topologie du réseau physique pour le scénario numéro \<ID> ;
- \<ID>_flotte.txt : nombre et types des barges disponibles pour le scénario numéro \<ID> ;
- \<ID>_demandes.txt : demandes de containers à transporter pour le scénario numéro \<ID> ;

Exemple pour le scénario N°1 : 1\_services.txt, 1\_topologie.txt, 1\_flotte.txt, 1\_demandes.txt

Pour le contenu des fichiers, vous pouvez vous baser sur l&#39;exemple fourni en annexe. Dans un premier test/scénario, il est possible que les données soient « figées » dans le code.

### 4.2. Structure de données centrale du simulateur : échéancier des événements

Dans le projet de M2 TNSID, en plus du modèle de simulation, une complication supplémentaire est lié à la conception du simulateur et de l&#39;outil de visualisation dédiés au problème traité !

Le simulateur à événements discret est basé sur un « échéancier » qui mémorise en principe les prochains événements à déclencher en fonction du temps. C&#39;est une file d&#39;événements localisés dans le temps et identifiés par un numéro d&#39;événement unique qui s&#39;incrémente à chaque création d&#39;un événement dans la file. Attention, ce numéro n&#39;est pas forcément croissant lorsque l&#39;on parcoure selon le temps croissant les événements mémorisés dans la file car il est possible d&#39;insérer un événement entre deux événements qui étaient déjà mémorisés.

Dans un premier temps, il est possible de mémoriser tous les événements depuis le début de simulation. Dans un second temps (si vous en avez le temps), il pourrait être intéressant de supprimer les événements ± au fur et à mesure qu&#39;ils sont déclenchés.

Concrètement, une structure de données (liste chaînée, « vecteur », table de hachage/dictionnaire…) contient des paquets/sacs d&#39;événements. Chaque sac d&#39;événements contient un ensemble d&#39;événements à déclencher au même instant de la simulation et est caractérisé par les événements qu&#39;il contient et l&#39;instant auquel il faut déclencher ces événements. En résumé, nous avons « une file de sacs d&#39;événements ».

Il faut naturellement pouvoir parcourir cette file de proche en proche en faisant avancer le temps (saut d&#39;un sac d&#39;événements au prochain dans le temps). Il faut pouvoir ajouter un sac d&#39;événements n&#39;importe où dans le temps (donc n&#39;importe où dans la file), sans revenir en arrière dans le temps évidemment. Il faut être capable de créer un sac d&#39;événements et d&#39;ajouter des événements dans un sac.

Au niveau d&#39;un sac, les événements ne sont pas forcément « classés/triés » mais il faut être capable de parcourir les événements contenus dans un sac (mathématiquement un sac est un ensemble avec une possibilité de parcourir ses éléments).

Si nous mémorisons tous les événements depuis le début de la simulation, il n&#39;est pas utile de prévoir la suppression d&#39;un événement dans un sac, ni la suppression d&#39;un sac de la file.

### 4.3. Types d&#39;événements

En programmation orientée-objet (POO), il est possible de faciliter la gestion de différents types d&#39;événements avec des attributs et méthodes ± dédié.e.s (via polymorphisme ou …). Ce qui suit est juste une liste d&#39;attributs potentiellement utiles pour caractériser un événement :

- type : arrivée (par qui ? de quoi ?), départ (par qui ? de quoi ?), attente (par qui ? de quoi ?), panne (de quoi ?), retard…
- identifiant : numéro auto-incrémenté
- temps : temps auquel l&#39;événement se produit, voir si utile au niveau d&#39;un événement si défini au niveau d&#39;un sac
- quantité : quantité associée à l&#39;événement, en TEUs
- ressource : ressource(s) concernée(s) (demande, barge, container, terminal, service…)
- origine/destination : selon le type d&#39;événements
- durée : si cela a un sens, selon le type d&#39;événements, peut être nulle, ou au contraire obtenue via un générateur de nombres pseudo-aléatoires.

## 5. Vérifier le code et les données

Nous ferons cela ensemble. Dans la réalité, il s&#39;agit de vérifier que le modèle fait bien ce qu&#39;il est censé faire et de détecter d&#39;éventuelles incohérences dans le modèle et/ou les données. Cette étape consiste à vérifier si le modèle reproduit la réalité sur base des données collectées.

## 6. Valider le modèle et les données

Nous ferons cela ensemble. Une fois que le modèle est vérifié à l&#39;étape 5, il s&#39;agit en cette étape d&#39;une confrontation du modèle à la réalité et/ou aux attentes du/des décideur.s. Cette étape consiste à vérifier – avec un expert du domaine – et, sur base de plusieurs scenarii, si le modèle répond bien aux attentes.

## 7. Exécuter la simulation selon un schéma d&#39;expérimentation

Nous ferons cela ensemble.

## 8. Dépouiller et analyser (avec un regard critique) les résultats

Nous ferons cela ensemble.

## 9. Rédiger le rapport final

Pour le projet en M2 TNSID, je ne demande pas ce rapport car vous avez peu de temps pour le rédiger et je préfère focaliser sur le [code du] modèle de simulation réalisé. Dans la réalité, il est très important car il entérine la prestation effectuée et la fin du paiement… Un cas particulier (au point suivant) peut conduire à négocier un contrat de maintenance/mises à jour périodiques du modèle/logiciel s&#39;il est installé en entreprise (ou plus généralement chez le client).

## 10. Mettre en service l&#39;application et/ou capitaliser le modèle

À voir ensemble.

## 11. Annexe 1 : Scénario de base à simuler

Le scénario à simuler est basé sur le document intitulé « Description partielle du problème à modéliser (12/10/2021) » et déposé sur Moodle le 12/01/2021. Il s&#39;agit d&#39;un réseau physique comportant 4 terminaux en ligne (A, B, C, D) :

![](https://i.postimg.cc/7ZvykzwJ/annexe1.png)

Le réseau espace-temps comporte 14 unités de temps d&#39;une demi-journée (soit un cycle d&#39;une semaine) :

![](https://i.postimg.cc/cJ0yKNKs/annexe2.png)

Tous les itinéraires envisageables sont couverts par les services définis/ouverts :

![](https://i.postimg.cc/xd5rMFHL/annexe3.png)

Dans un premier temps, il est possible de considérer un seul type de barges. Dans un second temps trois types de barges seront à considérer (petites, moyennes et grandes) en supposant qu&#39;elles aient la même vitesse. Dans un premier temps, vous pouvez tenter de simuler un seul service (le service 1 par exemple).

Les indicateurs de performance à fournir seront en terme de TEUs transportés en une semaine au total, par service et au niveau de chaque terminal.

La description des services est la suivante :

![](https://i.postimg.cc/B6nrgcck/annexe4.png) Dans cette table, pour chaque service à raison d&#39;un service par ligne :

- la colonne 1 correspond à l&#39;identifiant du service (numéro unique) ;
- les colonnes 2 et 3 sont respectivement l&#39;origine et la destination du service ;
- la colonne 4 donne la liste des arcs correspondant à un transport (legs) ;
- la colonne 5 donne l&#39;origine et la destination de chaque leg ;
- la colonne 6 fournit la durée de trajet sur chaque leg (en 1/2 journée) ;
- la colonne 7 précise le pas de temps (en 1/2 journée) où le service commence (début de chargement) ;
- la colonne 8 précise le pas de temps (en 1/2 journée) où le service s&#39;arrête (fin de déchargement) ;
- la colonne 9 précise le pas de temps (en 1/2 journée) où le trajet (premier leg emprunté) ;
- la colonne 10 précise le pas de temps (en 1/2 journée) où l&#39;on arrive à destination ;
- la colonne 11 précise les arrêts effectués (lieu et pas de temps) pendant le service ;
- la colonne 12 précise les fins des arrêts effectués (lieu et pas de temps) pendant le service ;
- la colonne 13 donne la capacité maximale du service en TEUs ;
- la colonne 14 donne le type et le nombre de barges qui circulent sur le service.

Les colonnes suivantes ne sont pas utiles pour la simulation.

À savoir que les capacités des barges sont les suivantes :

- petite barge (small) 10 TEUs ;
- moyenne barge (medium) 15 TEUs ;
- grande barge (large) 25 TEUs.

Si nous prenons le service 1, sur lequel circulent une grande et une petite barge, un maximum de 35 TEUs peuvent être transportés à tout instant sur n&#39;importe quel leg de ce service.

Pour un premier scenario, nous considérons les demandes suivantes :

![](https://i.postimg.cc/4xzRN3xL/annexe5.png)

Autrement dit :

- demande 1 de type F, entre A et D, départ au temps 0 et arrivée au temps 8 de 13 TEUs;
- demande 2 de type P, entre D et B, départ au temps 11 et arrivée au temps 1 (du prochain cycle) de 15 TEUs;
- demande 3 de type R, entre A et C, départ au temp 2 et arrivée au temps 13 de 20 TEUs;
- demande 4 de type T, entre D et B, départ au temps 0 et arrivée au temps 12 de 18 TEUs.

Pour la demande 2, si dans un premier temps vous ne pouvez simuler qu&#39;un cycle (de 0 à 13 1/2 journées), c&#39;est possible pour un premier test.

ATTENTION : il est possible que des demandes (i.e. des containers) attendent un service au niveau d&#39;un terminal (i.e. ce n&#39;est pas parce que les containers sont arrivés que le service « arrive » en même temps). Il est aussi possible qu&#39;une demande ne puisse pas arriver dans les temps car aucun service ne le permet. En ce cas, elle arrive bien à destination, dès que possible !

Dans de futurs scenarii, les demandes seront générées aléatoirement (loi uniforme) entre chaque paire origine/destination (OD) sur le réseau espace-temps considéré.

## 12. Annexe 2

Ce cahier des charges est incomplet et devra être complété au fil des séances de TP si cet exemple de projet est retenu effectivement comme projet pour l&#39;EC « Modélisation et Simulation des Systèmes Complexes ».