package org.homa;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class TimeTestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("time")
    public LocalDateTime helloTime() {


        return LocalDateTime.now();
    }

    @POST

    @Produces(MediaType.APPLICATION_JSON)
    @Path("time")
    public Timecontainer echoDate(Timecontainer tc) {
        return new Timecontainer(tc.localDateTime, tc.localDate, "   this is a teststring  ");
    }
}