-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)
SELECT title
FROM movie JOIN collection ON movie.collection_id = collection.collection_id AND collection.collection_name = 'Star Wars Collection'
    JOIN person ON movie.director_id = person.person_id AND person.person_name <> 'George Lucas'
