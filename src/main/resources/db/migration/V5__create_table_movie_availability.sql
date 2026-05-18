CREATE TABLE movie_availability(
    movie_id BIGINT,
    streaming_platform_id BIGINT,

    PRIMARY KEY (movie_id, streaming_platform_id),

    CONSTRAINT fk_movie_availability_movie
        FOREIGN KEY (movie_id) REFERENCES movie(id),

    CONSTRAINT fk_movie_availability_streaming_platform
        FOREIGN KEY (streaming_platform_id) REFERENCES streaming_platform(id)
);