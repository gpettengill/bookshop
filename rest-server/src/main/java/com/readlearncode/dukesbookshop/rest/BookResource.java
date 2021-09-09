package com.readlearncode.dukesbookshop.rest;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.readlearncode.dukesbookshop.domain.Book;
import com.readlearncode.dukesbookshop.infrastructure.BookRepository;

@Stateless
@Path("/books")
public class BookResource {

  @EJB
  private BookRepository bookRepository;

  @GET
  public Response getAllBooks() {
    //GKPNote: When creating this code in section 3_5, the infrastructure pkg (and the classes in it) didn't exist yet. It looks like the class
    //skipped the part about creating them.
    // I copied them from the 03_55_end directory. They also had the wrong pkg name (had "restserver" in the middle).  I took that out

    List<Book> books = bookRepository.getAll();
    GenericEntity<List<Book>> bookWrapper = new GenericEntity<List<Book>>(books) {
    };
    return Response.ok(bookWrapper).build();
  }

  @POST
  public Response saveBook(final Book book) {
    Book persistedBook = bookRepository.saveBook(book);
    return Response.ok(persistedBook).build();
  }

  @GET
  @Path("isbn: \\d{9} [\\d|X]$}")
  public Response getBookByIsbn(final @PathParam("isbn") String isbn) {
    //GKPNote: @Path uses regEx to ensure that this only gets called when pass an ISBN, as opposed to some other possible id #
    Optional<Book> book = bookRepository.getByISBN(isbn);
    if (book.isPresent()) {
      return Response.ok(book.get()).build();
    }
    return Response.noContent().build();
  }
}
