package gov.iti.jets.stream;

import java.io.FileWriter;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class JsonGeneratorDemo {

    public void produceJsonInStreamingFashion() throws Exception {
        JsonGenerator generator = Json.createGenerator(new FileWriter("movie.json"));

        generator.writeStartObject()                    // {
            .write("title", "The Matrix")               //      "title": "The Matrix",
            .write("year", 1999)                        //      "year": 1999,
            .writeStartArray("cast")                    //      "cast": [
                .write("Keanu Reeves")                  //          "Keanu Reeves",
                .write("Laurence Fishburne")            //          "Laurence Fishburne",
                .write("Carrie-Anne Moss")              //          "Carrie-Anne Moss"
            .writeEnd()                                 //      ]
        .writeEnd();                                    // }

        generator.flush();
        generator.close();
    }

}
