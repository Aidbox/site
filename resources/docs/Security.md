## Policies

Policy is a JSON schema filtering REST requests. The policy type PostgreSQL function is available on the 
form but at the moment only one policy type is working - JSON Schema. The Policy field is used to enter a JSON schema.
By default the Policy field is preset to the Basic template, you can select another template from available Basic, 
Advanced and Pro templates.

Let's consider the work of the Basic template. Here is the JSON schema of the template:

```
{
  "type": "object",
  "properties": {
    "method": {
      "constant": "GET"
    },
    "uri": {
      "type": "string",
      "pattern": "/fhir.*"
    }
  }
}
```
In this schema two constraints are introduced: 

1. it is allowed to use only the GET method;
2. it is allowed to use only request URIs starting with "/fhir".

Below the template selection element there is a tool for debugging. This tool consists of the following elements:

- HTTP-method selection (GET, POST, PUT, DELETE);
- command line for entering address, starting with /fhir (implying the base server address going before the slash);
- the Debug button;
- the Request Body area.

The Request Body area is used for displaying the request, the schema and the result with errors and warnings if any. 
For debugging the magic key __debug=true is used, so only request validation is performed, and the requests themselves 
are not executed. Let's perform the following tests to check our Basic template:

Positive:

1. select the GET method;
2. enter the URI /fhir/Patient;
3. click the Debug button.

Part result shows that there are no errors.

Negative: 


1. select the POST method;
2. enter the URI /users;
3. click the Debug button.

Part result shows that there are two errors: POST method is used and only GET method is allowed; 
URI should start with /fhir, but it starts with /users.

### How to add a new policy rule

1. Open the Policies tab;
2. Click the plus button;
3. Fill in the fields Id, Title, Type, Policy;
4. Click the Create button.

### Search by policy rule

To search by policy rule, simply enter the search text in the filter field. Records in the list will be 
immediately filtered according to your entry.

### How to edit a policy rule

1. Select required policy rule record in the list;
2. Perform necessary editing;
3. Click the Save button.

### How to delete a policy rule

1. Select required policy rule record in the list;
2. Click the Delete button;
3. The record will be deleted without confirmation.
