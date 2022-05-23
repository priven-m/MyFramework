package takeAlotTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
	
	/*
	* Rest assured is java library for testing Restful Web services.
	* It can be used to test XML & JSON based web services.
	* It supports GET, POST, PUT, PATCH, DELETE, OPTIONS and HEAD requests and
	* can be used to validate and verify the response of these requests.
	* Syntax: The syntax of Rest Assured.io is the most beautiful part, as it is
	* very gherkin syntax like and understandable.
	*
	* Given(). param("x", "y"). header("z", "w"). when(). Method(). Then().
	* statusCode(XXX). body("x, ”y", equalTo("z"));
	*
	* Given() ‘Given’ keyword, lets you set a background, here, you pass the
	* request headers, query and path param, body, cookies. This is optional if
	* these items are not needed in the request
	* When() ‘when’ keyword marks the
	* premise of your scenario. For example, ‘when’ you get/post/put something, do
	* something else. Method() Substitute this with any of the CRUD
	* operations(get/post/put/delete)
	* Then() Your assert and matcher conditions go
	* here
	*
	* Methods HTTP methods (GET, PUT, POST, PATCH and DELETE) and these methods can
	* be mapped to CRUD operations. GET retrieves the resource at a specified URI.
	* PUT updates a resource at a specified URI. Also be used to create a new
	* resource at a specified URI. Replaces the entire product entity. PATCH
	* support partial updates. POST creates a new resource. DELETE deletes a
	* resource at a specified URI.
	*/	

public class restFinal {
	
	@BeforeTest
	public void SetUp() {
		//specify the base url to the RESTFUL web service
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/books";
	}
	
	@Test
	public void getResponseExampleAndLogLoggingWithoutBaseURI() {
		given().
		when().
			get("https://demoqa.com/BookStore/v1/Books").
		then().
		log().all(); //This will log everything after receiving response from the server
	}
	
	@Test
	public void getResponseExampleAndLogLoggingWithBaseURI() {
		given().
		when().
			get("").
		then().
		log().all(); //This will log everything after receiving response from the server
	}
	
	@Test
	public void testISBNforFirstBook() {
		//books[0].isbn
		given().
		when().
			get("").
		then()
		.statusCode(200).
		body("books[0].isbn",equalTo("9781449325862"));
	}
	
	@Test
	public void testPublisherOfFourthBook() {
		//books[3].publisher
		given().
		when().
			get("").
		then()
		.statusCode(200).
		body("books[3].publisher",equalTo("O'Reilly Media"));
	}
	
	@Test
	public void testPageNumbersInt() {
		given().
		when().
			get("").
		then()
		.statusCode(200).
		body("books[2].pages",equalTo(28));
	}
	
	@Test
	public void testUsing2Assertions() {
		given().
		when().
			get("").
		then()
		.statusCode(200).
		and().
		body("books[2].pages",equalTo(238)).
		and().
		body("books[3].publisher",equalTo("O'Reilly Media"));
	}
	
	@Test
	public void testTiltesHasItem() {
		given().
		when().
			get("").
		then()
		.statusCode(200).
		body("books.subTitle",hasItems("Harnessing the Power of the Web"));
	}
	
	@Test
	public void testCreatingVariable() {
		String isbn = 
		given().
		when().
			get("").
		then().
		extract().path("books[0].isbn");
		System.out.println(isbn);
	}
	
	@Test
	public void testExtractList() {
		List <String> isbn = 
		given().
		when().
			get("").
		then().
		extract().path("books.isbn");
		System.out.println(isbn);
		
		//Iterate over the list and print individual book item
		for(String book : isbn)
		{
			System.out.println("ISBN " + book );
		}
	}
	
}
