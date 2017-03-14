/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.partokarwat.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.partokarwat.example.com",
                ownerName = "backend.myapplication.partokarwat.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /**
     * A simple endpoint method that takes a joke and returns it
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke joke = new Joke();
        joke.setData(new Joker().getJoke());

        return joke;
    }

}