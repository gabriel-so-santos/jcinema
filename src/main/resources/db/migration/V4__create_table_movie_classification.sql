CREATE TABLE movie_classification(
    movie_id BIGINT,
    movie_category_id BIGINT,

    PRIMARY KEY (movie_id, movie_category_id),

    CONSTRAINT fk_movie_classification_movie
        FOREIGN KEY (movie_id) REFERENCES movie(id),

    CONSTRAINT fk_movie_classification_category
        FOREIGN KEY (movie_category_id) REFERENCES movie_category(id)
);