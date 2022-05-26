package api.entitites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RequestEntity {

    public static Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }}