package org.acme.movies;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MoviesCatelog {
    List<Movies> moviesList = new java.util.ArrayList<>();
    List<String> movies = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response showMovies() {
        return Response.ok(movies).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public int MoviesCount() {
        return movies.size();
    }

    @Produces(MediaType.TEXT_PLAIN)
    @javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    @javax.ws.rs.POST
    public Response AddMovies(String addmovies) {

        return Response.ok(movies.add(addmovies)).build();
    }

    @Path("{movie_to_update}")
    @Produces(MediaType.TEXT_PLAIN)
    @javax.ws.rs.Consumes(MediaType.TEXT_PLAIN)
    @javax.ws.rs.PUT
    public Response updateMOvie(@javax.ws.rs.QueryParam("movie") String movie,
                                @javax.ws.rs.PathParam("movie_to_update") String movie_to_update) {
        movies = movies.stream().map(movieUPDATE -> {
            if (movieUPDATE.equals(movie_to_update)) {
                return movie;
            }
            return movie;
        }).collect(java.util.stream.Collectors.toList());
        return Response.accepted(movies).build();
    }

    @javax.ws.rs.DELETE
    @javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    @Path("/{movieToDelete}")
    public Response deleteMovie(@javax.ws.rs.PathParam("movieToDelete") String movieToDelete) {
        boolean removed = movies.remove(movieToDelete);
        return removed ? Response.noContent().build()
                : Response.status(Response.Status.BAD_REQUEST).build();
    }

}
