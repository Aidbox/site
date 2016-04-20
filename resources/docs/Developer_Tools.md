# How to work with the REST Console

First, you need to create a table of patients.

1. Open FHIRBase Console
2. Execute the following query:

```
SELECT fhir_create_storage('{"resourceType": "Patient"}'::json);
```

Then you can add a new patient:

1. Open REST Console
2. Select the POST method
3. Enter ```fhir/Patient``` after the slash
4. Paste a JSON example of the Patient resource from the FHIR specification, having removed a line with id assigning, into the request body.
5. Execute the request.

Let's check that the patient has been added:

1. Open FHIRBase Console
2. Execute the quety ```select * from patient limit 5;```

