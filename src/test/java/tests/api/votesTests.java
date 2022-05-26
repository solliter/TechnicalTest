package tests.api;

import api.entitites.VoteResponse;
import api.entitites.VotesResponse;
import api.helpers.helperVotes;
import org.testng.annotations.Test;

import java.util.List;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;


public class votesTests {


    @Test()
    public static void Objective1(){
        List<VotesResponse> votes = helperVotes.getVotesList();//a
        assertThat(votes.size(), not(0)); //b
   }

    @Test
    public static void Objective2(){
        List<VotesResponse> votes = helperVotes.getVotesList();
        int voteNumber = helperVotes.returnRandomVoteId(votes);
        VotesResponse vote = votes.get(voteNumber);
        VotesResponse votesByNumber = helperVotes.getVotesListById(vote.getId());//a

        //b
        assertThat(votesByNumber.getId(), equalTo(vote.getId()));
        assertThat(votesByNumber.getCountry_code(), equalTo(vote.getCountry_code()));
        assertThat(votesByNumber.getCreated_at(), equalTo(vote.getCreated_at()));
        assertThat(votesByNumber.getImage_id(), equalTo(vote.getImage_id()));
        assertThat(votesByNumber.getSub_id(), equalTo(vote.getSub_id()));
    }

    @Test
    public static void Objective3(){
        VoteResponse response = helperVotes.createVotes("myVote","vote123",1);//a
        assertThat(response.getId(), notNullValue());//b
        assertThat(response.getMessage(), is("SUCCESS"));//c
    }

    @Test
    public static void Objective4(){
        VoteResponse response = helperVotes.createVotes("myVote","vote123",1);
        VotesResponse votesByNumber = helperVotes.getVotesListById(response.getId());//a
        assertThat(votesByNumber.getId(), equalTo(response.getId()));//b
    }

    @Test
    public static void Objective5(){
        VoteResponse response = helperVotes.createVotes("myVote","vote123",1);
        VoteResponse deleteVoteByNumber = helperVotes.deleteVotesById(response.getId());
        assertThat(deleteVoteByNumber.getMessage(), equalTo("SUCCESS"));//a
    }

    @Test
    public static void Objective6(){
        VoteResponse response = helperVotes.createVotes("myVote","vote123",1);
        VoteResponse deleteVoteByNumber = helperVotes.deleteVotesById(response.getId());
        assertThat(deleteVoteByNumber.getMessage(), equalTo("SUCCESS"));
        VoteResponse deleteVoteByNegative = helperVotes.deleteVotesNegative(response.getId());//b
        assertThat(deleteVoteByNegative.getMessage(), equalTo("INVALID_ACCOUNT"));//a
        assertThat(deleteVoteByNegative.getStatus(), equalTo(400));//b

        //Somehow this objective in document is wrong and its message = INVALID_ACCOUNT and status 400

    }




}
