# REST Testing with Rest-Assured

## Objectives

* Write TestNG tests to exercise and validate REST Endpoints using the Rest-Assured library

## Instructions

A live API that manages Developer entities exists at https://tech-services-1000201953.uc.r.appspot.com/.  The 
Developer entity has the following shape:

```Java
public class Developer {

    String id; //MongoDB 
    String firstName;
    String lastName;
    String favoriteLanguage;
    int yearStarted;
}
```

###Endpoints

* GET /developers           : Returns all developers
* GET /developer/{id}       : Returns developer with specified id
* POST /developer           : Posts developer entity from request body
* PUT /developer            : Updates developer entity from request body
* DELETE /developer/{id}    : Deletes developer with specified id

The first POST test has been partially written for you:

```JAVA
public class DeveloperTests {

    Developer developer;
    String baseURL = "https://tech-services-1000201953.uc.r.appspot.com/";

    @BeforeSuite
    public void setup(){
        developer = new Developer("","","",0);//update me
    }

    @Test
    public void postDeveloper_postsDeveloper() throws IOException {
        // create a client
        Response response =  given()
                .header("Content-type", "application/json")
                .and()
                .body(developer)
                .when()
                .post(baseURL+"developer")
                .then()
                .extract().response();

        developer = response.getBody().as(Developer.class);
        assertEquals(response.statusCode(),200);
        assertEquals(developer.getFirstName(),"");//update me
        assertNotNull(developer.getId());

    }

}
```

Complete the DeveloperTests class to satisfy the 
below criteria:

1.  Update the new Developer Object with your developer info and update the first name assertion.
2.  Verify that the GET all developers endpoint returns an array of developers.
3.  Verify that the GET developer by id endpoint returns the expected developer.
4.  Verify that the PUT endpoint updates a developer.
5.  Verify that the DELETE endpoint deletes the developer.  Verify HttpStatus.OK and attempt to retrieve the deleted 
    developer and verify that it returns null.


#### Rest-Assured Guides
* [Rest Assured IO](https://rest-assured.io/)
* [DevQA rest-assured examples](https://devqa.io/rest-assured-api-requests-examples/)
* [Toolsqa Read json response body](https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/)
