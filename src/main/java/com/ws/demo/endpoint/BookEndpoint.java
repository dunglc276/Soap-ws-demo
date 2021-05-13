package com.ws.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ws.demo.repository.BookRepository;
import com.ws.demo.wsdl.GetBookRequest;
import com.ws.demo.wsdl.GetBookRespone;

@Endpoint
public class BookEndpoint {

	private static final String NAMESPACE_URI = "http://localhost:8080/xml/book";
	 
  private BookRepository bookRepository;

  @Autowired
  public BookEndpoint(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
  @ResponsePayload
  public GetBookRespone getCountry(@RequestPayload GetBookRequest request) {
      GetBookRespone response = new GetBookRespone();
      response.setBook(bookRepository.findBookById(request.getId()));
      return response;
  }
}
