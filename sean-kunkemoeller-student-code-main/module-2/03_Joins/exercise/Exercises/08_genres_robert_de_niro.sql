-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
SELECT DISTINCT genre_name
FROM genre JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
    JOIN movie ON movie_genre.movie_id = movie.movie_id AND movie.release_date >= '2010-01-01'
        JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
            JOIN person ON movie_actor.actor_id = person.person_id AND person.person_name = 'Robert De Niro'

