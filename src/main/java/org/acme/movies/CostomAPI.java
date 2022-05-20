package org.acme.movies;

@org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition(tags =
        {
                @org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "MoviesCatelog", description = "this is simple catloge")},
        info = @org.eclipse.microprofile.openapi.annotations.info.Info(
                title = "open api and swagger demo",
                version = "1.0.12",
                contact = @org.eclipse.microprofile.openapi.annotations.info.Contact(
                        name = "bigbigtutor",
                        url = "bigbigtutor.com",
                        email = "bigbigtutor.mail"

                )
        ))
public class CostomAPI extends javax.ws.rs.core.Application {

}
