-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in--include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'
SELECT COUNT(movie.movie_id) AS num_of_movies, person.person_name
FROM movie RIGHT JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
   RIGHT JOIN person ON movie_actor.actor_id = person.person_id
    WHERE person.person_name LIKE 'George %'
    GROUP BY person.person_name, person.person_id
    ORDER BY person.person_name


