# Implements methods and cases

**Protocol:**
Update persons:
Method: PUT
Request: http://localhost:2000/person
Body: id={id}&name={name}&phone={phone}
WHERE: 
{id} - person id which need update
{name} - person new name for update
{phone} - person new phone for update

---
Delete person:
Method: DELETE
Request: http://localhost:2000/person?id={id}
Body: EMPTY
WHERE:
{id} - person id which need delete


> Test all using Tools -> Http Client -> Test RESTful Web Services in IntelliJ IDEA

### Class PersonServiceImpl
```java
...
@Override  
public boolean add(PersonDto person) { 
    //Todo return false if person already exist 
    persons.put(person.getId(),person);  
    return true;  
}  
  
@Override  
public boolean delete(int id) {
    //Todo remove and return true if person with {id} exist
    //    return false if person with {id} don't exist     
    return false;  
}   
   
@Override  
public boolean update(PersonDto person) {
    //Todo update person if exist and return true
    //    return false if person don't exist  
    return false;  
}
...
```
---
### Class PersonController
```java
...
private RawHttpResponse person(RawHttpRequest request) {  
    RawHttpResponse response;  
    switch (request.method){  
    ...  
        case PUT:  
            //Todo Implements logic for update person
            //    int request body need by person as string
            response = getErrorResponse(RawHttpResponse.ResponseCode.BAD_REQUEST,"Bad request","Unsupported method:" + request.method);  
            break;  
        case DELETE:  
            //Todo implements logic for delete person
            //    request body empty, person id for delete in query params
            response = getErrorResponse(RawHttpResponse.ResponseCode.BAD_REQUEST,"Bad request","Unsupported method:" + request.method);  
            break;  
    ...  
    return response;  
}
...
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbNDgzMjQ5MDEzLDE3MzAxMDUwMCw3MzA5OT
gxMTZdfQ==
-->