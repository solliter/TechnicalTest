package api.helpers;
import api.entitites.CreateVoteRequest;
import api.entitites.VoteResponse;
import api.entitites.VotesResponse;
import io.restassured.http.ContentType;

import java.util.List;
import java.util.Random;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class helperVotes {



    public static List<VotesResponse> getVotesList() {
        return asList(given()
                .header("x-api-key", "DEMO-API-KEY")
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.thecatapi.com/v1/votes")
                .then()
                .statusCode(200)
                .extract()
                .as(VotesResponse[].class));
    }


    public static VotesResponse getVotesListById(int id) {
        VotesResponse someVotes = given()
                .header("x-api-key", "DEMO-API-KEY")
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.thecatapi.com/v1/votes/"+id+"")
                .then()
                .statusCode(200)
                .extract()
                .as(VotesResponse.class);
        assertThat(someVotes.getId(),notNullValue());
        return someVotes;
    }


    public static VoteResponse createVotes(String image_id, String sub_id, int value) {
        CreateVoteRequest body = new CreateVoteRequest()
                .setImage_id(image_id)
                .setSub_id(sub_id)
                .setValue(value);

        return given()
        .header("x-api-key", "DEMO-API-KEY")
        .contentType(ContentType.JSON)
        .body(body)
        .when()
        .post("https://api.thecatapi.com/v1/votes")
                .then()
                .statusCode(200)
                .extract()
                .as(VoteResponse.class);
    }

    public static VoteResponse deleteVotesById(int id) {
        VoteResponse deleteSomeVote = given()
                .header("x-api-key", "DEMO-API-KEY")
                .contentType(ContentType.JSON)
                .when()
                .delete("https://api.thecatapi.com/v1/votes/"+id+"")
                .as(VoteResponse.class);
        assertThat(deleteSomeVote.getMessage(),notNullValue());
        return deleteSomeVote;
    }

    public static VoteResponse deleteVotesNegative(int id) {
        VoteResponse deleteSomeVote = given()
                .header("x-api-key", "DEMO-API-KEY")
                .contentType(ContentType.JSON)
                .when()
                .delete("https://api.thecatapi.com/v1/votes/"+id+"")
                .then()
                .statusCode(400)
                .extract()
                .as(VoteResponse.class);
        assertThat(deleteSomeVote.getMessage(),notNullValue());
        return deleteSomeVote;
    }


    public static int returnRandomVoteId(List<VotesResponse> votes) {
        Random random = new Random();
        return  random.ints(0, votes.size()).findFirst().getAsInt();
    }



}

