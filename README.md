# GeocachingPOO

Application that allows recording and simulating recording activities and cache discoveries. The genesis of the application to be implemented is similar to that of well-known geo-caching social networks. The application to be created is in essence an information collection environment that will enable users to record their information on the activities of insertion (creation) and discovery of caches that they carry out and can also view the activities carried out by their friends.

The rationale for what is requested is the following:

- the application has a profile for each user who only accesses the information for which they have privileges: their personal information and their friends' records;
- each user performs a set of discovery and insertion of new caches that they register in the application. Each type of cache has its characteristics, so the necessary information must be saved to describe each type of cache that the program considers;
- each user has a set of friends, from whom they can see their activities;
- each user always has updated statistical information about what they did in a given month;
- there are cache discovery events that the application administration inserts and in which users can subscribe.

### Users

The following personal information is stored for each user:

- email, which is the user's key;
- password;
- name;
- gender;
- household;
- date of birth;

In addition to this information, which must be editable, the user also records:

- information about the activities you carried out;
- the statistics of your records in the different types of cache, and
- the set of users who belong to your network of friends.

### Caches

According to Wikipedia, a good definition of the various types of cache can be summarized as:

"In a traditional cache, a geocacher places a log book, pen or pencil and small treasures in a waterproof bag, and then writes down the WGS84 coordinates (latitude and longitude) of the cache. These, together with other information about the hiding place, are published on the Internet. The other geocachers, the discoverers, read this page and, using GPS receivers, look for it. When they succeed, they record the find on the same page. Geocachers are free to place or remove objects from the cache, normally in exchange for things of small value, so that there is always a souvenir to bring back.

Some caches contain what are called "travel bugs" or "geocoins" - objects that must move from cache to cache, and whose paths are recorded online.

### Some variations:

Micro-cache: small box that almost only fits the log book - the most common are 35mm photographic roll boxes. Multi-cache: requires a visit to one or more intermediate points to determine the coordinates of the final cache. Mystery cache: requires the geocacher to solve a puzzle to find it. Cache-event: a meeting of geocachers. Virtual: a place to visit without hidden boxes but which is supposed to have something beautiful or interesting. The visit will have to be proven by revealing something that guarantees that the geocacher was present."

The GeoCachingPOO application must know a list of the most known types of caches.

You can also store information about the weather conditions that exist during the course of the activity. The discovery of a cache will give users points, according to the difficulty of the cache itself and the weather conditions associated with the time of its discovery (which will obviously have to be simulated by the program).

### Basic Requirements

The application to be developed must have, among others, the following basic requirements:

- access the application using credentials (email and password);
- view information on the last 10 activities of yourself and your friends. By choosing an activity you can view its details;
- register the creation of a new cache (of one of the various types that the program considers);
- record information about a cache discovery activity;
- invalidate a previously inserted cache (operation that must be done by the cache creator or by a possible system administrator)
- "report abuse" of a cache
- query and remove discovery activities. The consultation must follow a chronological order, in a well-known "timeline" format used by social networks;
- access statistics (monthly and annual).

### Events

Application administrators can feed it with information regarding events that will take place and where users can register. Each event has a maximum number of participants allowed and a registration end date.

Depending on the user's history, an average value of time needed to discover a cache should be inferred. Factors such as the user's history with different types of cache can also be considered, the user's ability to be faster at finding caches according to various weather conditions, the distances at which the caches are located (note that for each cache enter latitude and longitude), etc.

Event simulations will comply with the following rules:

- the execution of each event is explicitly communicated to the program. It must be clear that the order to simulate the event has been given and the weather conditions must be indicated. Depending on these conditions, a factor must be calculated that will affect the performance of each user.
- the simulation will calculate for each user the time needed to discover a cache (you will have to simulate this using its history and random factors), and it should always be possible to see which users are discovering caches and the list of already identified caches.
- determine the user who wins the event, normally the one who will earn the most cache discovery points over the time the event lasts.

### Safeguarding the application state

The program must allow the information existing in memory about users, discovery and registration activities, caches, etc. to be saved to a file at any time. The recording must be done in such a way as to

allow the state that was recorded to be recovered again. When submitting the project, a status must also be provided (saved in a file) that can be uploaded during the presentation.