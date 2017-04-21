# Jackson annotation Example

This project is a sample implementation of few features from jackson serialization library and jsonschema2pojo maven plugin.

* The build creates POJOs from json schemas using jsonschema2pojo maven plugin. 
* If the schema specifies `skipSerialize : true` for a certain field, it will annotate that field with the custom `@SkipSerialize` annotation.
* Annotate POJO classes with Jackson's `@JsonFilter` annotation.
* The POJOs are exposed over HTTP as a REST endpoint using spring boot. Jackson library is used for serializing the POJOs to JSON output.
* The ObjectMapper that Jackson uses is customized to use a filter which will skip serialization of fields which are annotated with `@SkipSerialize`.

## Installation

Package the project using
`mvn clean package`

Install the project using
`mvn clean install`

Run the tests
`mvn test`

## Usage

Package the application using the command above.
Start the application using
`java -jar application/target/jackson-annotation-example-application-0.0.1-SNAPSHOT.jar`

Use the endpoints
http://localhost:8080/user
http://localhost:8080/cardInfo

## License

This project is licensed under the terms of the MIT license.